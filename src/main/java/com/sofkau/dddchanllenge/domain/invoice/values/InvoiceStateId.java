package com.sofkau.dddchanllenge.domain.invoice.values;

import co.com.sofka.domain.generic.Identity;
import com.sofkau.dddchanllenge.domain.order.values.DesignId;

public class InvoiceStateId extends Identity {

    public InvoiceStateId() {
    }

    private InvoiceStateId(String uuid) {
        super(uuid);
    }

    public static InvoiceStateId of(String id) {
        return new InvoiceStateId(id);
    }
}
