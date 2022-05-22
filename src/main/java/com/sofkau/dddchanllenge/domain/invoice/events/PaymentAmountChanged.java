package com.sofkau.dddchanllenge.domain.invoice.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.domain.invoice.values.Amount;
import com.sofkau.dddchanllenge.domain.shared.values.OrderId;

public class PaymentAmountChanged extends DomainEvent {
    private final Amount amount;

    public PaymentAmountChanged(Amount amount) {
        super("mateocardona.invoice.paymentamountchanged");
        this.amount = amount;
    }

    public Amount getAmount() {
        return amount;
    }
}
