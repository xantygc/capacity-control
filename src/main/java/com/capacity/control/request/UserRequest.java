package com.capacity.control.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class UserRequest
{
    private String name;
    private String firstName;
    private String surname;
    private String documentId;
    private LocalDate dateOfBirth;
    private String bonus;
    private String payment;
}
