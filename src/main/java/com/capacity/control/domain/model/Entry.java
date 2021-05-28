package com.capacity.control.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Entry
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private UUID uuid;
    private ActionType typeEntry;
    private UUID subscriber;
    private LocalDate entryDate;

    public Entry (UUID uuid, ActionType typeEntry, UUID subscriber, LocalDate entryDate, LocalDateTime entryTime)
    {
        this.uuid = uuid;
        this.typeEntry = typeEntry;
        this.subscriber = subscriber;
        this.entryDate = entryDate;
        this.entryTime = entryTime;
    }

    private LocalDateTime entryTime;


}
