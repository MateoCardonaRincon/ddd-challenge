package com.sofkau.dddchanllenge.domain.invoice.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.domain.shared.values.OrderId;

public class PaymentAmountChanged extends DomainEvent {
    private final OrderId orderId;

    public PaymentAmountChanged(OrderId orderId) {
        super("mateocardona.invoice.paymentamountchanged");
        this.orderId = orderId;
    }

    public OrderId getOrderId() {
        return orderId;
    }
}
