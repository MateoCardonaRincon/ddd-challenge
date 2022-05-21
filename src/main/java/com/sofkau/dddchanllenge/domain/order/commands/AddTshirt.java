package com.sofkau.dddchanllenge.domain.order.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddchanllenge.domain.order.values.Price;
import com.sofkau.dddchanllenge.domain.order.values.TshirtId;
import com.sofkau.dddchanllenge.domain.shared.values.OrderId;

public class AddTshirt extends Command {

    private final OrderId orderId;
    private final TshirtId tshirtId;
    private final Price price;

    public AddTshirt(OrderId orderId, TshirtId tshirtId, Price price) {
        this.orderId = orderId;
        this.tshirtId = tshirtId;
        this.price = price;
    }

    public OrderId getOrderId() {
        return orderId;
    }

    public TshirtId getTshirtId() {
        return tshirtId;
    }

    public Price getPrice() {
        return price;
    }
}
