package com.sofkau.dddchanllenge.domain.contract.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.domain.contract.values.DateOfContract;

public class ContractCreated extends DomainEvent {

    private final DateOfContract dateOfContract;

    public ContractCreated(DateOfContract dateOfContract) {
        super("mateocardona.contract.contractcreated");
        this.dateOfContract = dateOfContract;
    }

    public DateOfContract getDateOfContract() {
        return dateOfContract;
    }
}
