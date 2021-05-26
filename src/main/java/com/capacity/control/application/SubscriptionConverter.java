package com.capacity.control.application;

import com.capacity.control.domain.model.PaymentType;
import com.capacity.control.domain.model.Subscription;
import com.capacity.control.domain.model.SubscriptionType;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionConverter
{
    public Subscription convertToModel (com.capacity.control.dto.Subscription dto)
    {

        if (!dto.getType().equals(com.capacity.control.dto.SubscriptionType.INDIVIDUAL))
        {
            return new Subscription(SubscriptionType.valueOf(dto.getType().toString())
                    , PaymentType.valueOf(dto.getPayment().toString())
                    , dto.getCost()
                    , dto.getStartDate()
                    , dto.getEndDate()
                    , dto.getPaid()
                    , -1);
        }
        return new Subscription(SubscriptionType.valueOf(dto.getType().toString())
                , PaymentType.valueOf(dto.getPayment().toString())
                , dto.getCost()
                , dto.getStartDate()
                , dto.getEndDate()
                , dto.getPaid()
                , 10);
    }

    public com.capacity.control.dto.Subscription convertToDto (Subscription model)
    {
        return new com.capacity.control.dto.Subscription(model.getId()
                , com.capacity.control.dto.SubscriptionType.valueOf(model.getType().toString())
                , com.capacity.control.dto.PaymentType.valueOf(model.getPayment().toString())
                , model.getCost(), model.getStartDate(), model.getEndDate(), model.getPaid());
    }
}
