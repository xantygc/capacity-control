package com.capacity.control.exceptions;

import com.capacity.control.domain.model.Subscription;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor @Getter
public class OveruseSubscriptionException extends Exception
{
    private final String message;
    private final Subscription subscription;

}
