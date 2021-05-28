package com.capacity.control.application;

import com.capacity.control.dto.Subscriber;
import com.capacity.control.dto.Subscription;
import com.capacity.control.infraestructure.repositories.SubscriberRepository;
import com.capacity.control.infraestructure.repositories.SubscriptionRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class SubscriptionManagerService
{
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Autowired
    private LayerConverter converter;

    public void add (Subscription subscription, List<Subscriber> members)
    {
         
    }

    public void modify (Subscription subscription)
    {

    }

    public void delete (Subscription subscription)
    {

    }

    public void addMember (Subscription subscription, Subscriber subscriber)
    {

    }

    public void removeMember (Subscription subscription, Subscriber subscriber)
    {

    }


}
