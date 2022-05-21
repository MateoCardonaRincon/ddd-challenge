package com.sofkau.dddchanllenge.domain.order.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddchanllenge.domain.order.values.DateOfOrder;
import com.sofkau.dddchanllenge.domain.shared.values.OrderId;

public class ChangeDateOfOrder extends Command {

    private final OrderId orderId;
    private final DateOfOrder dateOfOrder;

    public ChangeDateOfOrder(OrderId orderId, DateOfOrder dateOfOrder) {
        this.orderId = orderId;
        this.dateOfOrder = dateOfOrder;
    }

    public OrderId getOrderId() {
        return orderId;
    }

    public DateOfOrder getDateOfOrder() {
        return dateOfOrder;
    }
}
