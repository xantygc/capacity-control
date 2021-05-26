package com.capacity.control.exceptions;

import com.capacity.control.domain.model.Subscriber;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
@Getter @AllArgsConstructor
public class LimitedCapacityException extends Exception
{
    private final String message;
    private final Subscriber subscriber;
}
