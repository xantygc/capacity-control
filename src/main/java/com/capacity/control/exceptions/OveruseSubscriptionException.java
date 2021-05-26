package com.capacity.control.exceptions;

import com.capacity.control.domain.model.Subscription;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.FORBIDDEN)
@AllArgsConstructor @Getter
public class OveruseSubscriptionException extends Exception
{
    private final String message;
    private final UUID subscription;

}
