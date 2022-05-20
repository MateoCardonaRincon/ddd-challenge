package com.sofkau.dddchanllenge.contract.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.contract.values.ClientId;
import com.sofkau.dddchanllenge.values.Name;

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
