package com.capacity.control.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class Location
{
    private final Integer id;
    private final String name;
    private final int capacity;
    private final int attendance;
}
