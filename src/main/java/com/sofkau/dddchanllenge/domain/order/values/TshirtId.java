package com.sofkau.dddchanllenge.domain.order.values;

import co.com.sofka.domain.generic.Identity;

public class TshirtId extends Identity {

    public TshirtId() {
    }

    private TshirtId(String uuid) {
        super(uuid);
    }

    public static TshirtId of(String id) {
        return new TshirtId(id);
    }
}
