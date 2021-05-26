package com.capacity.control.controller;

import com.capacity.control.application.SubscriberConverter;
import com.capacity.control.application.SubscriptionConverter;
import com.capacity.control.dto.Subscription;
import com.capacity.control.infraestructure.repositories.SubscriptionRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@Log4j2
@RequestMapping("/subscription")
public class SubscriptionController
{
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private SubscriptionConverter converter;


    @PostMapping
    public Subscription add (@RequestBody Subscription request)
    {
        com.capacity.control.domain.model.Subscription subscription = subscriptionRepository.save(converter.convertToModel(request));
        return converter.convertToDto(subscription);
    }

    @GetMapping
    public List<Subscription> list ()
    {
        return StreamSupport.stream(subscriptionRepository.findAll().spliterator(), true)
                .map(subscription -> converter.convertToDto(subscription))
                .collect(Collectors.toList());

    }
}
