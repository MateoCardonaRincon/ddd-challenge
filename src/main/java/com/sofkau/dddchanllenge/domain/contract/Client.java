package com.sofkau.dddchanllenge.domain.contract;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.dddchanllenge.domain.contract.values.ClientId;
import com.sofkau.dddchanllenge.domain.contract.values.ContactNumber;
import com.sofkau.dddchanllenge.domain.contract.values.Name;

import java.util.Objects;

public class Client extends Entity<ClientId> {

    private Name name;
    private ContactNumber contactNumber;

    public Client(ClientId clientId, Name name, ContactNumber contactNumber) {
        super(clientId);
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public void changeClientName(Name name) {
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
