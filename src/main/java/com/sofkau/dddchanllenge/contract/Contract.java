package com.sofkau.dddchanllenge.contract;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofkau.dddchanllenge.contract.events.ContractCreated;
import com.sofkau.dddchanllenge.contract.values.ContractId;
import com.sofkau.dddchanllenge.contract.values.DateOfContract;

public class Contract extends AggregateEvent<ContractId> {

    protected DateOfContract dateOfContract;
    protected Client client;
    protected Stamper stamper;

    public Contract(ContractId entityId, DateOfContract dateOfContract) {
        super(entityId);
        appendChange(new ContractCreated(dateOfContract)).apply();
    }
}
