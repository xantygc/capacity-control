package com.capacity.control.exceptions;

import com.capacity.control.domain.model.Subscriber;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class SubscriptorAlreadyExistsException extends Throwable
{
    private final String message;
    private final Subscriber subscriber;
}
