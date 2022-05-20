package com.sofkau.dddchanllenge.contract.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddchanllenge.contract.values.DateOfContract;
import com.sofkau.dddchanllenge.values.ContractId;

public class ChangeDateOfContract extends Command {
    private final ContractId contractId;
    private final DateOfContract dateOfContract;

    public ChangeDateOfContract(ContractId contractId, DateOfContract dateOfContract) {
        this.contractId = contractId;
        this.dateOfContract = dateOfContract;
    }

    public ContractId getContractId() {
        return contractId;
    }

    public DateOfContract getDateOfContract() {
        return dateOfContract;
    }
}
