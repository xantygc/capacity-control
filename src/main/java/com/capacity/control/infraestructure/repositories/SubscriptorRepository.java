package com.capacity.control.infraestructure.repositories;

import com.capacity.control.domain.model.Subscriptor;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SubscriptorRepository extends CrudRepository<Subscriptor, UUID>
{
}
