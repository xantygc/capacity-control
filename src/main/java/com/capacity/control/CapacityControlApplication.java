package com.capacity.control;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CapacityControlApplication
{

    public static void main (String[] args)
    {
        SpringApplication.run(CapacityControlApplication.class, args);
    }

}
