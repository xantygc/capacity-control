package com.capacity.control.controller;


import com.capacity.control.application.BarcodeGenerator;
import com.capacity.control.application.LayerConverter;
import com.capacity.control.infraestructure.repositories.SubscriberRepository;
import com.capacity.control.dto.Subscriber;
import lombok.extern.log4j.Log4j2;
import net.sourceforge.barbecue.BarcodeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@Log4j2
@RequestMapping("/subscriber")
public class SubscriberController
{
    @Autowired
    private SubscriberRepository subscriberRepository;

    @Autowired
    private BarcodeGenerator barcodeGenerator;

    @Autowired
    private LayerConverter converter;

    @PostMapping
    public Subscriber add (@RequestBody Subscriber request)
    {
        com.capacity.control.domain.model.Subscriber subscriber = subscriberRepository.save(converter.convertToModel(request));
        return converter.convertToDto(subscriber);
    }

    @GetMapping
    public List<Subscriber> get()
    {
        return StreamSupport.stream(subscriberRepository.findAll().spliterator(), false)
                .map(subscriber -> converter.convertToDto(subscriber))
                .collect(Collectors.toList());
    }


    @GetMapping(path = "{id}/barcode", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> generateBarcode(@PathVariable UUID id) throws BarcodeException
    {
        byte[] bytes = null;
        Optional<com.capacity.control.domain.model.Subscriber> subscriber = subscriberRepository.findByUuid(id);
        if(subscriber.isPresent())
        {
            bytes = barcodeGenerator.generate(subscriber.get().getBarcode()).toByteArray();
            return ResponseEntity.ok()
                    .header("Content-Disposition", "filename=" + id.toString() + ".jpg")
                    .body(bytes);
        }
        throw new BarcodeException("Error occurred trying to recovery barcode", null);
    }
}
