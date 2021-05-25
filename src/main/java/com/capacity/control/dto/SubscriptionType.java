package com.capacity.control.dto;

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
