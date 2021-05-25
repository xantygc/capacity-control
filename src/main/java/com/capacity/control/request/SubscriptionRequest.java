package com.capacity.control.request;

import com.capacity.control.domain.model.PaymentType;
import com.capacity.control.domain.model.SubscriptionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @AllArgsConstructor @NoArgsConstructor
public class SubscriptionRequest
{
    private SubscriptionType type;
    private PaymentType payment;
    private BigDecimal cost;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean paid = false;
}
