package com.sofkau.dddchanllenge.contract.values;

import co.com.sofka.domain.generic.Identity;

public class StamperId extends Identity {

    public StamperId() {
    }

    private StamperId(String uuid) {
        super(uuid);
    }

    public static StamperId of(String id) {
        return new StamperId(id);
    }
}
