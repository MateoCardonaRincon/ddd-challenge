package com.sofkau.dddchanllenge.contract.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.contract.values.StamperId;
import com.sofkau.dddchanllenge.values.ContactNumber;
import com.sofkau.dddchanllenge.values.Name;

public class StamperAdded extends DomainEvent {
    private final StamperId stamperId;
    private final Name name;
    private final ContactNumber contactNumber;

    public StamperAdded(StamperId stamperId, Name name, ContactNumber contactNumber) {
        super("mateocardona.contract.stamperadded");
        this.stamperId = stamperId;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public StamperId getStamperId() {
        return stamperId;
    }

    public Name getName() {
        return name;
    }

    public ContactNumber getContactNumber() {
        return contactNumber;
    }
}
