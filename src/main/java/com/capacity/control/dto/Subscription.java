package com.capacity.control.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Subscription
{
    private UUID id;
    private SubscriptionType type;
    private PaymentType payment;
    private BigDecimal cost;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean paid = false;
}
