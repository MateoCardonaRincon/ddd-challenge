package com.sofkau.dddchanllenge.domain.shared.values;

import co.com.sofka.domain.generic.Identity;

public class InvoiceId extends Identity {

    public InvoiceId() {
    }

    private InvoiceId(String uuid) {
        super(uuid);
    }

    public static InvoiceId of(String id) {
        return new InvoiceId(id);
    }
}
