package com.sofkau.dddchanllenge.domain.order.values;

import co.com.sofka.domain.generic.Identity;

public class DesignId extends Identity {

    public DesignId() {
    }

    private DesignId(String uuid) {
        super(uuid);
    }

    public static DesignId of(String id) {
        return new DesignId(id);
    }
}
