package com.capacity.control.application;

import com.capacity.control.domain.model.Location;
import com.capacity.control.domain.model.Subscriber;
import org.springframework.stereotype.Service;

@Service
public class SubscriberConverter
{
    public Subscriber convertToModel(com.capacity.control.dto.Subscriber dto)
    {
        Location location = new Location();
        location.setId(dto.getLocationId());
        return new Subscriber(dto.getSubscriptionId(), dto.getName(), dto.getSurname(),dto.getBirthdate(),dto.getDocumentId(),dto.getAddress(), location);
    }

    public com.capacity.control.dto.Subscriber convertToDto(Subscriber model)
    {
        return new com.capacity.control.dto.Subscriber(model.getId(), model.getName(),model.getSubscription().getId(),model.getSurname(),model.getDocumentId(),model.getBirthdate(),model.getAddress(),model.getLocation().getId());
    }


}
