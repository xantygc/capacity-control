package com.capacity.control.controller;


import com.capacity.control.request.UserRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping("/user")
public class UserController
{
    @PostMapping
    public void register(@RequestBody UserRequest userRequest)
    {

    }
}
