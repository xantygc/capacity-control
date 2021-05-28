package com.capacity.control.infraestructure.repositories;

import com.capacity.control.domain.model.Subscription;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SubscriptionRepository extends CrudRepository<Subscription, UUID>
{
    Subscription findByUuid(UUID uuid);
}
