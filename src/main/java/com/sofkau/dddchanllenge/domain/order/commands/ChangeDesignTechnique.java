package com.sofkau.dddchanllenge.domain.order.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddchanllenge.domain.order.values.Technique;
import com.sofkau.dddchanllenge.domain.shared.values.OrderId;

public class ChangeDesignTechnique extends Command {

    private final OrderId orderId;
    private final Technique technique;

    public ChangeDesignTechnique(OrderId orderId, Technique technique) {
        this.orderId = orderId;
        this.technique = technique;
    }

    public OrderId getOrderId() {
        return orderId;
    }

    public Technique getTechnique() {
        return technique;
    }
}
