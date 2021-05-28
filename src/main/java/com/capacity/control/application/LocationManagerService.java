package com.capacity.control.application;

import com.capacity.control.domain.model.Subscriber;
import com.capacity.control.exceptions.CapacityException;
import com.capacity.control.exceptions.OveruseSubscriptionException;
import com.capacity.control.infraestructure.repositories.EntryRepository;
import com.capacity.control.infraestructure.repositories.LocationRepository;
import com.capacity.control.infraestructure.repositories.SubscriberRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class LocationManagerService
{
    private final SubscriberRepository subscriberRepository;
    private final LocationRepository locationRepository;
    private final EntryRepository entryRepository;

    @Autowired
    public LocationManagerService (SubscriberRepository subscriberRepository, LocationRepository locationRepository, EntryRepository entryRepository)
    {
        this.subscriberRepository = subscriberRepository;
        this.locationRepository = locationRepository;
        this.entryRepository = entryRepository;
    }

    public Boolean registerEntry (Integer id, String barcode) throws CapacityException, OveruseSubscriptionException
    {
        log.info("Starting to register entry for barcode [" + barcode + "]");
        Optional<Subscriber> subscriber = subscriberRepository.findByBarcode(barcode.substring(0, barcode.length() - 1));
        Optional<com.capacity.control.domain.model.Location> location = locationRepository.findById(id);
        if (subscriber.isPresent() && location.isPresent())
        {
            if ((location.get().getAttendance() + 1) > location.get().getCapacity())
            {
                throw new CapacityException("Aforo completo", null);
            }

            if (subscriber.get().isRegister())
            {
                throw new OveruseSubscriptionException("Abono reutilizado", subscriber.get().getSubscription());
            }

            subscriber.get().register();
            subscriberRepository.save(subscriber.get());
            location.get().setAttendance(location.get().getAttendance() + 1);
            locationRepository.save(location.get());
        }

        return Boolean.TRUE;
    }

    public Boolean unregisterEntry (Integer id, String barcode) throws OveruseSubscriptionException
    {
        Optional<Subscriber> subscriber = subscriberRepository.findByBarcode(barcode.substring(0, barcode.length() - 1));
        Optional<com.capacity.control.domain.model.Location> location = locationRepository.findById(id);
        if (subscriber.isPresent() && location.isPresent())
        {
            if (subscriber.get().isRegister())
            {
                throw new OveruseSubscriptionException("Abono ya pasado", subscriber.get().getSubscription());
            }
            subscriber.get().unregister();
            subscriberRepository.save(subscriber.get());
            location.get().setAttendance(location.get().getAttendance() - 1);
            locationRepository.save(location.get());
        }

        return Boolean.TRUE;
    }
}
