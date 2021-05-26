package com.capacity.control.infraestructure.repositories;

import com.capacity.control.domain.model.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Integer>
{
}
