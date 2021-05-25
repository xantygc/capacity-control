package com.capacity.control.controller;


import com.capacity.control.domain.model.Subscriptor;
import com.capacity.control.infraestructure.repositories.SubscriptorRepository;
import com.capacity.control.request.SubscriptionRequest;
import com.capacity.control.request.SubscriptorRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping("/subscriptor")
public class SubscriptorController
{
    private SubscriptorRepository subscriptorRepository;

    @PostMapping
    public void register (@RequestBody SubscriptorRequest request)
    {
        Subscriptor subscriptor = new Subscriptor(request.getSubscriptionId(), request.getName(), request.getSurname(), request.getBirthdate(), request.getDocumentId(), request.getAddress());
        subscriptorRepository.save(subscriptor);
    }
}
