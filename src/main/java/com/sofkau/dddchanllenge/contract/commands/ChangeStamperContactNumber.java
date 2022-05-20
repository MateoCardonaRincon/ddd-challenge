package com.sofkau.dddchanllenge.contract.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddchanllenge.values.ContactNumber;
import com.sofkau.dddchanllenge.values.ContractId;

public class ChangeStamperContactNumber extends Command {
    private final ContractId contractId;
    private final ContactNumber contactNumber;

    public ChangeStamperContactNumber(ContractId contractId, ContactNumber contactNumber) {
        this.contractId = contractId;
        this.contactNumber = contactNumber;
    }

    public ContractId getContractId() {
        return contractId;
    }

    public ContactNumber getContactNumber() {
        return contactNumber;
    }
}
