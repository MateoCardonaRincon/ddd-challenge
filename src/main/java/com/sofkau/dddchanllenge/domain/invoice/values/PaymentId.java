package com.sofkau.dddchanllenge.domain.invoice.values;

import co.com.sofka.domain.generic.Identity;

public class PaymentId extends Identity {

    public PaymentId() {
    }

    private PaymentId(String uuid) {
        super(uuid);
    }

    public static PaymentId of(String id) {
        return new PaymentId(id);
    }
}
