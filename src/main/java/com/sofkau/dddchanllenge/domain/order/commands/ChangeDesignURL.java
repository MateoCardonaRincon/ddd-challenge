package com.sofkau.dddchanllenge.domain.order.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddchanllenge.domain.order.values.URL;
import com.sofkau.dddchanllenge.domain.shared.values.OrderId;

public class ChangeDesignURL extends Command {

    private final OrderId orderId;
    private final URL url;

    public ChangeDesignURL(OrderId orderId, URL url) {
        this.orderId = orderId;
        this.url = url;
    }

    public OrderId getOrderId() {
        return orderId;
    }

    public URL getUrl() {
        return url;
    }
}
