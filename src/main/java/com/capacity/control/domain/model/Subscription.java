package com.capacity.control.domain.model;

import com.capacity.control.exceptions.SubscriptorAlreadyExistsException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
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
    private int id;
    private UUID uuid = UUID.randomUUID();
    private SubscriptionType type;
    private PaymentType payment;
    private BigDecimal cost;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean paid = false;
    private Integer times = -1;
    @ManyToOne
    private Location location;
    @OneToMany(mappedBy = "subscription")
    private List<Subscriber> subscribers = new ArrayList<>();

    public Subscription (UUID subscriptionId)
    {
        this.uuid = subscriptionId;
    }

    public void reduceTime ()
    {
        if (times > 0)
        {
            this.times = this.times - 1;
        }

    }

    public void addMember (Subscriber subscriber) throws SubscriptorAlreadyExistsException
    {
        if (subscribers.stream().anyMatch(m -> m.getId()==subscriber.getId()))
        {
            throw new SubscriptorAlreadyExistsException("Este miembro ya existe en este abono", subscriber);
        }
        subscribers.add(subscriber);
    }

    public void paid (PaymentType type, BigDecimal amount)
    {
        this.payment = type;
        this.cost = amount;
        this.paid = true;
    }


}
