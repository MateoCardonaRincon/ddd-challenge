package com.sofkau.dddchanllenge.domain.contract;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.dddchanllenge.domain.contract.values.StamperId;
import com.sofkau.dddchanllenge.domain.shared.values.ContactNumber;
import com.sofkau.dddchanllenge.domain.shared.values.Name;

import java.util.Objects;

public class Stamper extends Entity<StamperId> {

    private Name name;
    private ContactNumber contactNumber;

    public Stamper(StamperId entityId, Name name, ContactNumber contactNumber) {
        super(entityId);
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public void changeStamperName(Name name) {
        this.name = Objects.requireNonNull(name);
    }

    public void changeStamperContactNumber(ContactNumber contactNumber) {
        this.contactNumber = Objects.requireNonNull(contactNumber);
    }

    public Name name() {
        return name;
    }

    public ContactNumber contactNumber() {
        return contactNumber;
    }
}
