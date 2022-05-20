package com.sofkau.dddchanllenge.contract;

import co.com.sofka.domain.generic.EventChange;
import com.sofkau.dddchanllenge.contract.events.ContractCreated;

public class ContractChange extends EventChange {

    public ContractChange(Contract contract) {
        apply((ContractCreated event) -> {
            contract.dateOfContract = event.getDateOfContract();
        });
    }
}
