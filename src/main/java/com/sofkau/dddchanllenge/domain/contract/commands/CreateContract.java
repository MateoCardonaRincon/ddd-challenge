package com.sofkau.dddchanllenge.domain.contract.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddchanllenge.domain.contract.values.DateOfContract;
import com.sofkau.dddchanllenge.domain.shared.values.ContractId;

public class CreateContract extends Command {

    private final ContractId contractId;
    private final DateOfContract dateOfContract;

    public CreateContract(ContractId contractId, DateOfContract dateOfContract) {
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
