package com.sofkau.dddchanllenge.contract.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.values.Name;

public class StamperNameChanged extends DomainEvent {
    private final Name name;

    public StamperNameChanged(Name name) {
        super("mateocardona.contract.stampernamechanged");
        this.name = name;
    }

    public Name getName() {
        return name;
    }
}
