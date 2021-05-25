package com.capacity.control.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Subscriptor
{
    @Id
    private UUID id = UUID.randomUUID();
    private UUID subscriptionId;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private String documentId;
    private String address;

    public Subscriptor (UUID subscriptionId, String name, String surname, LocalDate birthdate, String documentId, String address)
    {
        this.subscriptionId = subscriptionId;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.documentId = documentId;
        this.address = address;
    }
}
