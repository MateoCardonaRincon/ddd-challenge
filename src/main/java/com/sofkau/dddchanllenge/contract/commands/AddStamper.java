package com.sofkau.dddchanllenge.contract.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddchanllenge.values.ContactNumber;
import com.sofkau.dddchanllenge.values.ContractId;
import com.sofkau.dddchanllenge.values.Name;

public class AddStamper extends Command {
    private final ContractId contractId;
    private final Name name;
    private final ContactNumber contactNumber;

    public AddStamper(ContractId contractId, Name name, ContactNumber contactNumber) {
        this.contractId = contractId;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public ContractId getContractId() {
        return contractId;
    }

    public Name getName() {
        return name;
    }

    public ContactNumber getContactNumber() {
        return contactNumber;
    }
}
