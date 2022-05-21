package com.sofkau.dddchanllenge.domain.order.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.domain.order.values.Done;
import com.sofkau.dddchanllenge.domain.order.values.Price;
import com.sofkau.dddchanllenge.domain.order.values.TshirtId;

public class TshirtAdded extends DomainEvent {
    private final TshirtId tshirtId;
    private final Price price;
    private final Done done;

    public TshirtAdded(TshirtId tshirtId, Price price) {
        super("mateocardona.order.tshirtadded");
        this.tshirtId = tshirtId;
        this.price = price;
        this.done = new Done();
    }

    public TshirtId getTshirtId() {
        return tshirtId;
    }

    public Price getPrice() {
        return price;
    }

    public Done getDone() {
        return done;
    }
}
