package com.capacity.control.domain.model;

import com.capacity.control.exceptions.LimitedCapacityException;
import com.capacity.control.exceptions.OveruseSubscriptionException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter @AllArgsConstructor
public class Attendace
{
    private Integer maximum;
    private Integer actual;
    private List<Subscriptor> subscriptors = new ArrayList<>();

    private void addSuscriptor(Subscriptor subscriptor) throws OveruseSubscriptionException, LimitedCapacityException
    {

        if (!subscriptors.stream().filter(s -> s.getId().equals(subscriptor.getId())).findFirst().isEmpty())
        {
            throw  new OveruseSubscriptionException("Este abono ya está siendo utilizado", null);
        }

        if((actual + 1) > maximum)
        {
            throw new LimitedCapacityException("Se ha superado el aforo maximo", subscriptor);
        }

        subscriptors.add(subscriptor);
        actual = actual + 1;

    }
}
