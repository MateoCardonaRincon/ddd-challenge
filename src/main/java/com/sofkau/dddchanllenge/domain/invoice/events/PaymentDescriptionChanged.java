package com.sofkau.dddchanllenge.domain.invoice.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.domain.invoice.values.Description;

public class PaymentDescriptionChanged extends DomainEvent {
    private final Description description;

    public PaymentDescriptionChanged(Description description) {
        super("mateocardona.invoice.paymentdescriptionchanged");
        this.description = description;
    }

    public Description getDescription() {
        return description;
    }
}
