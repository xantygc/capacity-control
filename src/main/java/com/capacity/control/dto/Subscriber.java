package com.capacity.control.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Subscriber
{
    private UUID id;
    private String name;
    private UUID subscriptionId;
    private String surname;
    private String documentId;
    private LocalDate birthdate;
    private String address;
    private Integer locationId;
}
