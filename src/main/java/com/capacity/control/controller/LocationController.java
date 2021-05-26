package com.capacity.control.controller;

import com.capacity.control.domain.model.Subscriber;
import com.capacity.control.dto.Location;
import com.capacity.control.exceptions.CapacityException;
import com.capacity.control.exceptions.OveruseSubscriptionException;
import com.capacity.control.infraestructure.repositories.LocationRepository;
import com.capacity.control.infraestructure.repositories.SubscriberRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@Log4j2
@RequestMapping("/location")
public class LocationController
{
    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private SubscriberRepository subscriberRepository;

    @PostMapping
    public void add(@RequestBody Location location)
    {
        com.capacity.control.domain.model.Location newLocation = new com.capacity.control.domain.model.Location(location.getName(), location.getCapacity());
        locationRepository.save(newLocation);
    }

    @GetMapping
    public List<Location> findAll()
    {
        return StreamSupport.stream(locationRepository.findAll().spliterator(), false)
                .map(location -> new Location(location.getId(),location.getName(), location.getCapacity(), location.getAttendance()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Location findOne(@PathVariable Integer id)
    {
        Optional<com.capacity.control.domain.model.Location> location = locationRepository.findById(id);
        if(location.isPresent())
        {
            return new Location(location.get().getId(), location.get().getName(),location.get().getCapacity(),location.get().getAttendance());
        }
        return null;
    }

    @GetMapping("/{id}/attendance")
    public Integer attendance(@PathVariable Integer id)
    {
        Optional<com.capacity.control.domain.model.Location> location = locationRepository.findById(id);
        if (location.isPresent())
        {
            return location.get().getAttendance();
        }
        return null;
    }

    @GetMapping("/{id}/capacity")
    public Integer capacity(@PathVariable Integer id)
    {
        Optional<com.capacity.control.domain.model.Location> location = locationRepository.findById(id);
        if (location.isPresent())
        {
            return location.get().getCapacity();
        }
        return null;
    }

    @GetMapping("/{id}/register/{barcode}")
    public void register(@PathVariable Integer id, @PathVariable String barcode) throws CapacityException, OveruseSubscriptionException
    {
        Optional<Subscriber> subscriber = subscriberRepository.findByBarcode(barcode.substring(0,barcode.length()-1));
        Optional<com.capacity.control.domain.model.Location> location = locationRepository.findById(id);
        if(subscriber.isPresent() && location.isPresent())
        {
            if((location.get().getAttendance() + 1) > location.get().getCapacity())
            {
                throw new CapacityException("Aforo completo", null);
            }

            if(subscriber.get().isRegister())
            {
                throw new OveruseSubscriptionException("Abono reutilizado", subscriber.get().getSubscription().getId());
            }

            subscriber.get().register();
            subscriberRepository.save(subscriber.get());
            location.get().setAttendance(location.get().getAttendance() + 1);
            locationRepository.save(location.get());
        }
    }

    @GetMapping("/{id}/unregister/{barcode}")
    public void unregister(@PathVariable Integer id, @PathVariable String barcode) throws OveruseSubscriptionException
    {
        Optional<Subscriber> subscriber = subscriberRepository.findByBarcode(barcode.substring(0,barcode.length()-1));
        Optional<com.capacity.control.domain.model.Location> location = locationRepository.findById(id);
        if(subscriber.isPresent() && location.isPresent())
        {
            if(subscriber.get().isRegister())
            {
                throw new OveruseSubscriptionException("Abono ya pasado", subscriber.get().getSubscription().getId());
            }
            subscriber.get().unregister();
            subscriberRepository.save(subscriber.get());
            location.get().setAttendance(location.get().getAttendance() - 1);
            locationRepository.save(location.get());
        }
    }
}
