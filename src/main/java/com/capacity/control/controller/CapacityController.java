package com.capacity.control.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Log4j2
@RequestMapping("/capacity")
public class CapacityController
{

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Integer> getActualCapacity()
    {
        return ResponseEntity.of(Optional.ofNullable(0));
    }

    @GetMapping("/add/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public synchronized ResponseEntity<Integer> add(@PathVariable("userId") String userId)
    {
        final Integer actualCapacity = getActualCapacity().getBody();
        return ResponseEntity.of(Optional.of(actualCapacity + 1));
    }

    @GetMapping("/remove/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public synchronized ResponseEntity<Integer> remove(@PathVariable("userId") String userId)
    {
        Integer actualCapacity = getActualCapacity().getBody();
        actualCapacity = actualCapacity > 0 ? 0 : actualCapacity - 1;
        return ResponseEntity.of(Optional.of(actualCapacity));
    }
}
