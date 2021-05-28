package com.capacity.control.controller;

import com.capacity.control.application.LocationManagerService;
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
    private LocationManagerService locationManagerService;

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
                .map(location -> new Location(location.getUuid(),location.getName(), location.getCapacity(), location.getAttendance()))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Location findOne(@PathVariable Integer id)
    {
        Optional<com.capacity.control.domain.model.Location> location = locationRepository.findById(id);
        if(location.isPresent())
        {
            return new Location(location.get().getUuid(), location.get().getName(),location.get().getCapacity(),location.get().getAttendance());
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
        locationManagerService.registerEntry(id, barcode);
    }

    @GetMapping("/{id}/unregister/{barcode}")
    public void unregister(@PathVariable Integer id, @PathVariable String barcode) throws OveruseSubscriptionException
    {
        locationManagerService.unregisterEntry(id, barcode);
    }
}
