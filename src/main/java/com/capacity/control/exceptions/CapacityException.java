package com.capacity.control.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class CapacityException extends Throwable
{
    public CapacityException(String message, Throwable e)
    {
        super(message, e);
    }
}
