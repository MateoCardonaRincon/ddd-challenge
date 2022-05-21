package com.sofkau.dddchanllenge.domain.order.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddchanllenge.domain.order.values.DesignId;
import com.sofkau.dddchanllenge.domain.order.values.Technique;
import com.sofkau.dddchanllenge.domain.order.values.URL;
import com.sofkau.dddchanllenge.domain.shared.values.OrderId;

public class AddDesign extends Command {

    private final OrderId orderId;
    private final DesignId designId;
    private final URL url;
    private final Technique technique;

    public AddDesign(OrderId orderId, DesignId designId, URL url, Technique technique) {
        this.orderId = orderId;
        this.designId = designId;
        this.url = url;
        this.technique = technique;
    }

    public OrderId getOrderId() {
        return orderId;
    }

    public DesignId getDesignId() {
        return designId;
    }

    public URL getUrl() {
        return url;
    }

    public Technique getTechnique() {
        return technique;
    }
}
