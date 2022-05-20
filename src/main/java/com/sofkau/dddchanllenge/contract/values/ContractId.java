package com.sofkau.dddchanllenge.contract.values;

import co.com.sofka.domain.generic.Identity;

public class ContractId extends Identity {

    public ContractId() {
    }

    private ContractId(String uuid) {
        super(uuid);
    }

    public static ContractId of(String id) {
        return new ContractId(id);
    }
}
