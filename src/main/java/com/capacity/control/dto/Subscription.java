package com.capacity.control.dto;

import com.capacity.control.exceptions.SubscriptorAlreadyExistsException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Subscription
{
    public Subscription (SubscriptionType type, PaymentType payment, BigDecimal cost, LocalDate startDate, LocalDate endDate, Boolean paid, Integer times)
    {
        this.type = type;
        this.payment = payment;
        this.cost = cost;
        this.startDate = startDate;
        this.endDate = endDate;
        this.paid = paid;
        this.times = times;
    }

    private SubscriptionType type;
    private PaymentType payment;
    private BigDecimal cost;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean paid = false;
    private Integer times = -1;
    private List<Subscriptor> members;

}
