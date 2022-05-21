package com.sofkau.dddchanllenge.domain.invoice.values;

import co.com.sofka.domain.generic.Identity;
import com.sofkau.dddchanllenge.domain.order.values.DesignId;

public class PaymentMethodId extends Identity {

    public PaymentMethodId() {
    }

    private PaymentMethodId(String uuid) {
        super(uuid);
    }

    public static PaymentMethodId of(String id) {
        return new PaymentMethodId(id);
    }
}
