package com.sofkau.dddchanllenge.domain.contract;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.dddchanllenge.domain.contract.values.ClientId;
import com.sofkau.dddchanllenge.domain.shared.values.ContactNumber;
import com.sofkau.dddchanllenge.domain.shared.values.Name;

import java.util.Objects;

public class Client extends Entity<ClientId> {

    private Name name;
    private ContactNumber contactNumber;

    public Client(ClientId entityId, Name name, ContactNumber contactNumber) {
        super(entityId);
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public void ChangeClientName(Name name) {
        this.name = Objects.requireNonNull(name);
    }

    public void changeClientContactNumber(ContactNumber contactNumber) {
        this.contactNumber = Objects.requireNonNull(contactNumber);
    }

    public Name name() {
        return name;
    }

    public ContactNumber contactNumber() {
        return contactNumber;
    }
}
