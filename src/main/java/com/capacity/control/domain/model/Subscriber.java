package com.capacity.control.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
public class Subscriber
{
    @Id
    private int id;
    private UUID uuid = UUID.randomUUID();
    @ManyToOne
    @JoinColumn(name="id", nullable=false, insertable = false, updatable = false)
    private Subscription subscription;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private String documentId;
    private String address;
    private boolean register;
    private String barcode;
    private String relationship;

    public Subscriber (Subscription subscription, String name, String surname, LocalDate birthdate, String documentId, String address, String relationship)
    {
        this.subscription = subscription;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.documentId = documentId;
        this.address = address;
        this.relationship = relationship;


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
