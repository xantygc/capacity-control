package com.capacity.control.domain.model;

public enum SubscriptionType
{
    FAMILIAR("FAMILIAR"),
    INDIVIDUAL("INDIVIDUAL");

    private String fare;

    SubscriptionType (String fare)
    {
        this.fare = fare;
    }
}
