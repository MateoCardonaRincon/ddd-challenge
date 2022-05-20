package com.sofkau.dddchanllenge.contract.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.contract.values.ClientId;
import com.sofkau.dddchanllenge.values.ContactNumber;
import com.sofkau.dddchanllenge.values.Name;

public class ClientAdded extends DomainEvent {
    private final ClientId clientId;
    private final Name name;
    private final ContactNumber contactNumber;

    public ClientAdded(ClientId clientId, Name name, ContactNumber contactNumber) {
        super("mateocardona.contract.clientadded");
        this.clientId = clientId;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public ClientId getClientId() {
        return clientId;
    }

    public Name getName() {
        return name;
    }

    public ContactNumber getContactNumber() {
        return contactNumber;
    }
}
