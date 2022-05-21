package com.sofkau.dddchanllenge.domain.contract.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.domain.shared.values.OrderId;

public class OrderAssociatedToContract extends DomainEvent {
    private final OrderId orderId;

    public OrderAssociatedToContract(OrderId orderId) {
        super("mateocardona.contract.orderassociatedtocontract");
        this.orderId = orderId;
    }

    public OrderId getOrderId() {
        return orderId;
    }
}
