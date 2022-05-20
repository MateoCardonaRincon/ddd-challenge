package com.sofkau.dddchanllenge.contract.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.contract.values.DateOfContract;

public class DateOfContractChanged extends DomainEvent {

    private final DateOfContract dateOfContract;

    public DateOfContractChanged(DateOfContract dateOfContract) {
        super("mateocardona.contract.dateofcontractchanged");
        this.dateOfContract = dateOfContract;
    }

    public DateOfContract getDateOfContract() {
        return dateOfContract;
    }
}
