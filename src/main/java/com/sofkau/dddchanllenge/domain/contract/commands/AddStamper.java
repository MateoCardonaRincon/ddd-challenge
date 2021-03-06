package com.sofkau.dddchanllenge.domain.contract.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddchanllenge.domain.contract.values.StamperId;
import com.sofkau.dddchanllenge.domain.contract.values.ContactNumber;
import com.sofkau.dddchanllenge.domain.contract.values.Name;
import com.sofkau.dddchanllenge.domain.shared.values.ContractId;

public class AddStamper extends Command {
    private final ContractId contractId;
    private final StamperId stamperId;
    private final Name name;
    private final ContactNumber contactNumber;

    public AddStamper(ContractId contractId, StamperId stamperId, Name name, ContactNumber contactNumber) {
        this.contractId = contractId;
        this.stamperId = stamperId;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public ContractId getContractId() {
        return contractId;
    }

    public StamperId getStamperId() {
        return stamperId;
    }

    public Name getName() {
        return name;
    }

    public ContactNumber getContactNumber() {
        return contactNumber;
    }
}
