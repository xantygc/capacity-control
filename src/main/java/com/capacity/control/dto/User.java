package com.capacity.control.dto;

import com.capacity.control.enums.BonusType;
import com.capacity.control.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User
{
    private String name;
    private String firstName;
    private String surname;
    private String documentId;
    private LocalDate dateOfBirth;
    private BonusType bonusType;
    private PaymentType paymentType;
}
