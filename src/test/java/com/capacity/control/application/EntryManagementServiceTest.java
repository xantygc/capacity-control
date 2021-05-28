package com.capacity.control.application;

import com.capacity.control.dto.ActionType;
import com.capacity.control.dto.Entry;
import com.capacity.control.dto.Subscriber;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EntryManagementServiceTest
{

    @Autowired
    private EntryManagementService entryManagementService;

    @Test
    void add ()
    {
        Subscriber subscriber = new Subscriber(UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa6")
                , "SANTIAGO"
                , UUID.fromString("3fa85f64-5717-4562-b3fc-2c963f66afa6")
                , "GONZALEZ"
                , "49010835C"
                , LocalDate.of(1982,6,21)
                ,"CALLE DE CASTILLA 9 4B"
                , "HIJO" );

        Entry entry = new Entry(ActionType.ENTRANCE, subscriber.getId());
        entryManagementService.add(entry);
    }

}