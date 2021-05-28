package com.capacity.control.application;

import com.capacity.control.domain.model.*;
import com.capacity.control.dto.Entry;
import com.capacity.control.dto.Location;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LayerConverter
{
    public Subscriber convertToModel (com.capacity.control.dto.Subscriber dto)
    {
        Subscription subscription = new Subscription(dto.getSubscription_id());
        return new Subscriber(subscription, dto.getName(), dto.getSurname(), dto.getBirthdate(), dto.getDocumentId(), dto.getAddress(), dto.getRelationship());
    }

    public com.capacity.control.dto.Subscriber convertToDto (Subscriber model)
    {
        return new com.capacity.control.dto.Subscriber(model.getUuid(), model.getName(), model.getSubscription().getUuid(), model.getSurname(), model.getDocumentId(), model.getBirthdate(), model.getAddress(), model.getRelationship());
    }

    public Subscription convertToModel (com.capacity.control.dto.Subscription dto)
    {

        if (!dto.getType().equals(com.capacity.control.dto.SubscriptionType.INDIVIDUAL))
        {
            return new Subscription(SubscriptionType.valueOf(dto.getType().toString())
                    , PaymentType.valueOf(dto.getPayment().toString())
                    , dto.getCost()
                    , dto.getStartDate()
                    , dto.getEndDate()
                    , dto.getPaid()
                    , -1);
        }
        return new Subscription(SubscriptionType.valueOf(dto.getType().toString())
                , PaymentType.valueOf(dto.getPayment().toString())
                , dto.getCost()
                , dto.getStartDate()
                , dto.getEndDate()
                , dto.getPaid()
                , 10);
    }

    public com.capacity.control.dto.Subscription convertToDto (Subscription model)
    {

        List<com.capacity.control.dto.Subscriber> members = model.getSubscribers().stream().map(this::convertToDto).collect(Collectors.toList());

        return new com.capacity.control.dto.Subscription(model.getUuid()
                , com.capacity.control.dto.SubscriptionType.valueOf(model.getType().toString())
                , com.capacity.control.dto.PaymentType.valueOf(model.getPayment().toString())
                , model.getCost(), model.getStartDate(), model.getEndDate(), convertToDto(model.getLocation()), model.getPaid(), members);
    }

    Location convertToDto (com.capacity.control.domain.model.Location model)
    {
        return new Location(model.getUuid(), model.getName(), model.getCapacity(), model.getAttendance());
    }

    com.capacity.control.domain.model.Location convertToModel (Location dto)
    {
        return new com.capacity.control.domain.model.Location(dto.getUuid(), dto.getName(), dto.getCapacity(), dto.getAttendance());
    }

    public com.capacity.control.domain.model.Entry convertToModel (Entry dto)
    {
        return new com.capacity.control.domain.model.Entry(dto.getUuid(), ActionType.valueOf(dto.getTypeEntry().toString()),dto.getSubscriber(),dto.getEntryDate(),dto.getEntryTime());
    }

    public Entry convertToDto(com.capacity.control.domain.model.Entry model)
    {
        return new Entry(model.getUuid(), com.capacity.control.dto.ActionType.valueOf(model.getTypeEntry().toString()),model.getUuid(),model.getEntryDate(),model.getEntryTime());
    }
}
