package com.sofkau.dddchanllenge.domain.contract.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddchanllenge.domain.shared.values.ContractId;
import com.sofkau.dddchanllenge.domain.contract.values.Name;

public class ChangeStamperName extends Command {
    private final ContractId contractId;
    private final Name name;

    public ChangeStamperName(ContractId contractId, Name name) {
        this.contractId = contractId;
        this.name = name;
    }

    public ContractId getContractId() {
        return contractId;
    }

    public Name getName() {
        return name;
    }
}
