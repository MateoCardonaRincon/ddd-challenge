package com.sofkau.dddchanllenge.domain.order.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddchanllenge.domain.shared.values.OrderId;

public class CompleteOrder extends Command {

    private final OrderId orderId;

    public CompleteOrder(OrderId orderId) {
        this.orderId = orderId;
    }

    public OrderId getOrderId() {
        return orderId;
    }
}
