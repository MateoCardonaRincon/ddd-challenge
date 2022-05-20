package com.sofkau.dddchanllenge.domain.contract.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.domain.shared.values.ContactNumber;

public class ClientContactNumberChanged extends DomainEvent {
    private final ContactNumber contactNumber;

    public ClientContactNumberChanged(ContactNumber contactNumber) {
        super("mateocardona.contract.clientcontactnumberchanged");
        this.contactNumber = contactNumber;
    }

    public ContactNumber getContactNumber() {
        return contactNumber;
    }
}
