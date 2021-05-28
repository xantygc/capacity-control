package com.capacity.control.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter @AllArgsConstructor
public class Location
{
    private final UUID uuid;
    private final String name;
    private final int capacity;
    private final int attendance;
}
