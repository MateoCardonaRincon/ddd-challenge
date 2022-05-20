package com.sofkau.dddchanllenge.domain.contract.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.domain.shared.values.ContactNumber;

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
