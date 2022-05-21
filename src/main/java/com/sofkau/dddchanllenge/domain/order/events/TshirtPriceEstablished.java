package com.sofkau.dddchanllenge.domain.order.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.domain.order.values.Price;
import com.sofkau.dddchanllenge.domain.order.values.TshirtId;

public class TshirtPriceEstablished extends DomainEvent {
    private final TshirtId tshirtId;
    private final Price price;

    public TshirtPriceEstablished(TshirtId tshirtId, Price price) {
        super("mateocardona.order.tshirtpriceestablished");
        this.tshirtId = tshirtId;
        this.price = price;
    }

    public TshirtId getTshirtId() {
        return tshirtId;
    }

    public Price getPrice() {
        return price;
    }
}
