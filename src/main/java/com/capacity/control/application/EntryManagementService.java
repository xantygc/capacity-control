package com.capacity.control.application;

import com.capacity.control.dto.Entry;
import com.capacity.control.infraestructure.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryManagementService
{

    private final EntryRepository repository;
    private final LayerConverter layerConverter;

    @Autowired
    public EntryManagementService (EntryRepository repository, LayerConverter layerConverter)
    {
        this.repository = repository;
        this.layerConverter = layerConverter;
    }

    Entry add(Entry entry)
    {
        return layerConverter.convertToDto(repository.save(layerConverter.convertToModel(entry)));
    }
}
