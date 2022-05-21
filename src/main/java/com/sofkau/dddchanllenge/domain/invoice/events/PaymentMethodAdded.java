package com.sofkau.dddchanllenge.domain.invoice.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.domain.invoice.values.Amount;
import com.sofkau.dddchanllenge.domain.invoice.values.Description;
import com.sofkau.dddchanllenge.domain.invoice.values.PaymentMethodId;

public class PaymentMethodAdded extends DomainEvent {
    private final PaymentMethodId paymentMethodId;
    private final Description description;
    private final Amount amount;

    public PaymentMethodAdded(PaymentMethodId paymentMethodId, Description description, Amount amount) {
        super("mateocardona.invoice.paymentmethodadded");
        this.paymentMethodId = paymentMethodId;
        this.description = description;
        this.amount = amount;
    }

    public PaymentMethodId getPaymentMethodId() {
        return paymentMethodId;
    }

    public Description getDescription() {
        return description;
    }

    public Amount getAmount() {
        return amount;
    }
}
