package com.sofkau.dddchanllenge.domain.contract.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddchanllenge.domain.shared.values.ContactNumber;
import com.sofkau.dddchanllenge.domain.shared.values.ContractId;
import com.sofkau.dddchanllenge.domain.shared.values.Name;

public class AddClient extends Command {
    private final ContractId contractId;
    private final Name name;
    private final ContactNumber contactNumber;

    public AddClient(ContractId contractId, Name name, ContactNumber contactNumber) {
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
