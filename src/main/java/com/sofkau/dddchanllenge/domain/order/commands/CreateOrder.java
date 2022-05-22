package com.sofkau.dddchanllenge.domain.order.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddchanllenge.domain.order.Tshirt;
import com.sofkau.dddchanllenge.domain.order.values.DateOfOrder;
import com.sofkau.dddchanllenge.domain.shared.values.OrderId;

import java.util.List;


public class CreateOrder extends Command {

    private final OrderId orderId;
    private final DateOfOrder dateOfOrder;

    public CreateOrder(OrderId orderId, DateOfOrder dateOfOrder) {
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
