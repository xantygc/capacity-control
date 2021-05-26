package com.capacity.control.infraestructure.repositories;

import com.capacity.control.domain.model.Subscriber;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface SubscriberRepository extends CrudRepository<Subscriber, UUID>
{
    Optional<Subscriber> findByBarcode(String barcode);
}
