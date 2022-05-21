package com.sofkau.dddchanllenge.domain.order;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.dddchanllenge.domain.order.values.Done;
import com.sofkau.dddchanllenge.domain.order.values.Price;
import com.sofkau.dddchanllenge.domain.order.values.TshirtId;

import java.util.Objects;

public class Tshirt extends Entity<TshirtId> {

    private Done done;
    private Price price;

    public Tshirt(TshirtId tshirtId, Price price) {
        super(tshirtId);
        this.price = price;
        this.done = new Done();
    }

    public void checkTshirtAsDone() {
        this.done = Done.check();
    }

    public void establishTshirtPrice(Price price) {
        this.price = Objects.requireNonNull(price);
    }

    public Done done() {
        return done;
    }

    public Price price() {
        return price;
    }
}
