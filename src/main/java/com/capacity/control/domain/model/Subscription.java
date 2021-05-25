package com.capacity.control.domain.model;

import com.capacity.control.exceptions.SubscriptorAlreadyExistsException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor @NoArgsConstructor
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

    @Id
    private UUID id = UUID.randomUUID();
    private SubscriptionType type;
    private PaymentType payment;
    private BigDecimal cost;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean paid = false;
    private Integer times = -1;
    @OneToMany
    private List<Subscriptor> members;

    public void reduceTime ()
    {
        if (times > 0)
        {
            this.times = this.times - 1;
        }

    }

    public void addMember (Subscriptor subscriptor) throws SubscriptorAlreadyExistsException
    {
        if (members.stream().anyMatch(m -> m.getId().equals(subscriptor.getId())))
        {
            throw new SubscriptorAlreadyExistsException("Este miembro ya existe en este abono", subscriptor);
        }
        members.add(subscriptor);
    }

    public void paid (PaymentType type, BigDecimal amount)
    {
        this.payment = type;
        this.cost = amount;
        this.paid = true;
    }


}
