package com.sofkau.dddchanllenge.contract.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.values.ContactNumber;

public class StamperContactNumberChanged extends DomainEvent {
    private final ContactNumber contactNumber;

    public StamperContactNumberChanged(ContactNumber contactNumber) {
        super("mateocardona.contract.stampercontactnumberchanged");
        this.contactNumber = contactNumber;
    }

    public ContactNumber getContactNumber() {
        return contactNumber;
    }
}
