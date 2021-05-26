package com.capacity.control.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Subscriber
{
    @Id
    private UUID id = UUID.randomUUID();
    @ManyToOne
    private Subscription subscription;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private String documentId;
    private String address;
    private boolean register;
    @ManyToOne
    private Location location;
    private String barcode;

    public Subscriber (UUID subscriptionId, String name, String surname, LocalDate birthdate, String documentId, String address, Location location)
    {
        Subscription subscription = new Subscription(subscriptionId);

        this.subscription = subscription;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.documentId = documentId;
        this.address = address;
        this.location = location;

        int year = LocalDate.now().getYear();
        StringBuilder barcodeText = new StringBuilder();
        barcodeText = barcodeText.append(year).append(documentId.substring(0, documentId.length()-1));
        this.barcode = String.format("%1$" + 12 + "s", barcodeText).replace(' ', '0');
    }

    public void register ()
    {
        this.register = true;
    }

    public void unregister ()
    {
        this.register = false;
    }
}
