package com.capacity.control.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Entry
{
    private UUID uuid;
    private ActionType typeEntry;
    private UUID subscriber;
    private LocalDate entryDate;
    private LocalDateTime entryTime;

    public Entry (ActionType typeEntry, UUID subscriber)
    {
        this.uuid = UUID.randomUUID();
        this.typeEntry = typeEntry;
        this.subscriber = subscriber;
        this.entryDate = LocalDate.now();
        this.entryTime = LocalDateTime.now();
    }

    public Entry (UUID uuid, ActionType typeEntry, UUID subscriber, LocalDate entryDate, LocalDateTime entryTime)
    {
        this.uuid = uuid;
        this.typeEntry = typeEntry;
        this.subscriber = subscriber;
        this.entryDate = entryDate;
        this.entryTime = entryTime;
    }
}
