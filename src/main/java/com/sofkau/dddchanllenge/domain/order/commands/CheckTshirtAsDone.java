package com.sofkau.dddchanllenge.domain.order.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddchanllenge.domain.order.values.TshirtId;
import com.sofkau.dddchanllenge.domain.shared.values.OrderId;

public class CheckTshirtAsDone extends Command {

    private final OrderId orderId;
    private final TshirtId tshirtId;

    public CheckTshirtAsDone(OrderId orderId, TshirtId tshirtId) {
        this.orderId = orderId;
        this.tshirtId = tshirtId;
    }

    public OrderId getOrderId() {
        return orderId;
    }

    public TshirtId getTshirtId() {
        return tshirtId;
    }
}
