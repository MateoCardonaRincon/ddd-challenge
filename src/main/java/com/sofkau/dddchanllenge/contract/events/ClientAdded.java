package com.sofkau.dddchanllenge.contract.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.contract.values.ClientId;
import com.sofkau.dddchanllenge.values.ContactNumber;
import com.sofkau.dddchanllenge.values.Name;

public class ClientAdded extends DomainEvent {
    private final ClientId entityId;
    private final Name name;
    private final ContactNumber contactNumber;

    public ClientAdded(ClientId entityId, Name name, ContactNumber contactNumber) {
        super("mateocardona.contract.clientadded");
        this.entityId = entityId;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public ClientId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }

    public ContactNumber getContactNumber() {
        return contactNumber;
    }
}
