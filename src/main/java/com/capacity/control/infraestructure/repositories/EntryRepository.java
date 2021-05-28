package com.capacity.control.infraestructure.repositories;


import com.capacity.control.domain.model.Entry;
import org.springframework.data.repository.CrudRepository;

public interface EntryRepository extends CrudRepository<Entry, Integer>
{

}
