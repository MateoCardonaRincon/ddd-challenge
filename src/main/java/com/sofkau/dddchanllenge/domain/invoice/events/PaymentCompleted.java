package com.sofkau.dddchanllenge.domain.invoice.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.domain.invoice.values.Payed;

public class PaymentCompleted extends DomainEvent {

    private final Payed payed;

    public PaymentCompleted() {
        super("mateocardona.invoice.paymentcompleted");
        payed = Payed.pay();
    }

    public Payed getPayed() {
        return payed;
    }
}
