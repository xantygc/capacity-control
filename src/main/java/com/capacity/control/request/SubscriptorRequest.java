package com.capacity.control.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class SubscriptorRequest
{
    private String name;
    private UUID subscriptionId;
    private String surname;
    private String documentId;
    private LocalDate birthdate;
    private String payment;
    private String address;
}
