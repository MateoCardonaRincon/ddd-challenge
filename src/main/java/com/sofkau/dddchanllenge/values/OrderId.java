package com.sofkau.dddchanllenge.values;

import co.com.sofka.domain.generic.Identity;

public class OrderId extends Identity {

    public OrderId() {
    }

    private OrderId(String uuid) {
        super(uuid);
    }

    public static OrderId of(String id) {
        return new OrderId(id);
    }
}
