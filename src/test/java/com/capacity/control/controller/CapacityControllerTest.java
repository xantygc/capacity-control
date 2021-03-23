package com.capacity.control.controller;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CapacityController.class)
@Log4j2
public class CapacityControllerTest
{

    @Autowired
    private MockMvc mvc;

    @Test
    public void getActualCapacity ()
    {
        try
        {
            mvc.perform(get("/capacity").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        } catch (Exception exception)
        {
            fail();
        }
    }

    @Test
    public void getActualCapacityValue ()
    {
        try
        {
            mvc.perform(get("/capacity").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString().equals("0");
        } catch (Exception exception)
        {
            fail();
        }
    }

    @Test
    public void add ()
    {
        try
        {
            mvc.perform(get("/capacity/add/12345").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        } catch (Exception exception)
        {
            fail();
        }
    }

    @Test
    public void addEvaluateCapacity ()
    {
        try
        {
            Integer capacity = Integer.valueOf(mvc.perform(get("/capacity").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString());
            capacity = capacity + 1;
            Integer actualCapacity = Integer.valueOf(mvc.perform(get("/capacity/add/12345").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString());
            assertEquals(capacity, actualCapacity);
        } catch (Exception exception)
        {
            fail();
        }
    }

    @Test
    public void remove ()
    {
        try
        {
            mvc.perform(get("/capacity/remove/12345").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        } catch (Exception exception)
        {
            fail();
        }
    }

    @Test
    public void removeEvaluateCapacity ()
    {
        try
        {
            Integer capacity = Integer.valueOf(mvc.perform(get("/capacity").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString());
            capacity = capacity > 0 ? 0 : capacity - 1;
            Integer actualCapacity = Integer.valueOf(mvc.perform(get("/capacity/remove/12345").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString());
            assertEquals(capacity, actualCapacity);
        } catch (Exception exception)
        {
            fail();
        }
    }
}