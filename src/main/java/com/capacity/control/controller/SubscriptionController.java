package com.capacity.control.controller;

import com.capacity.control.domain.model.Subscription;
import com.capacity.control.infraestructure.repositories.SubscriptionRepository;
import com.capacity.control.request.SubscriptionRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Log4j2
@RequestMapping("/subscription")
public class SubscriptionController
{
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @PostMapping
    public void add(@RequestBody SubscriptionRequest subscriptionRequest)
    {
        Subscription subscription = new Subscription(subscriptionRequest.getType(), subscriptionRequest.getPayment(), subscriptionRequest.getCost(), subscriptionRequest.getStartDate(), subscriptionRequest.getEndDate(), subscriptionRequest.getPaid(), 10);
        subscriptionRepository.save(subscription);
    }

    @GetMapping
    public Iterable<Subscription> list()
    {
        return subscriptionRepository.findAll();
    }
}
