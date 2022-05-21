package com.sofkau.dddchanllenge.domain.contract.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.domain.contract.values.Name;

public class ClientNameChanged extends DomainEvent {
    private final Name name;

    public ClientNameChanged(Name name) {
        super("mateocardona.contract.clientnamechanged");
        this.name = name;
    }
    
    public Name getName() {
        return name;
    }
}
