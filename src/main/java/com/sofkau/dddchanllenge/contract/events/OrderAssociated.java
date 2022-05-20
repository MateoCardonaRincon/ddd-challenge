package com.sofkau.dddchanllenge.contract.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.values.OrderId;

public class OrderAssociated extends DomainEvent {
    private final OrderId orderId;

    public OrderAssociated(OrderId orderId) {
        super("mateocardona.contract.orderassociated");
        this.orderId = orderId;
    }

    public OrderId getOrderId() {
        return orderId;
    }
}
