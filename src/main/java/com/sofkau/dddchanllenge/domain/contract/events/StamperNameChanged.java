package com.sofkau.dddchanllenge.domain.contract.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.domain.shared.values.Name;

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
