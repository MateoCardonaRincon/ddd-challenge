package com.sofkau.dddchanllenge.contract.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.contract.values.DateOfContract;

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
