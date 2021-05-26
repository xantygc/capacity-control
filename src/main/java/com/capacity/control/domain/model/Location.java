package com.capacity.control.domain.model;

import com.capacity.control.exceptions.CapacityException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Location
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int capacity;
    private int attendance = 0;

    public Location (String name, Integer capacity)
    {
        this.name = name;
        this.capacity = capacity;
    }

    public Integer addAttendace() throws CapacityException
    {
        if((attendance + 1) <= capacity)
        {
            attendance = attendance + 1;
            return attendance;
        }

        throw new CapacityException("Capacidad superada",null);
    }
}
