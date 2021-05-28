package com.capacity.control.application;

import com.capacity.control.exceptions.CapacityException;
import com.capacity.control.exceptions.OveruseSubscriptionException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LocationManagerServiceTest
{

    @Autowired
    private LocationManagerService locationManagerService;

    @Test
    void registerEntry () throws CapacityException, OveruseSubscriptionException
    {
        assertTrue(locationManagerService.registerEntry(1, "4007630000112"));
        assertThrows(OveruseSubscriptionException.class, () -> locationManagerService.registerEntry(1, "4007630000112"));
    }

    @Test
    void unregisterEntry () throws CapacityException, OveruseSubscriptionException
    {
        locationManagerService.registerEntry(1, "4007630000112");
        assertTrue(locationManagerService.unregisterEntry(1, "4007630000112"));
        assertThrows(OveruseSubscriptionException.class, () -> locationManagerService.unregisterEntry(1, "4007630000112"));
    }
}