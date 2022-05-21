package com.sofkau.dddchanllenge.domain.order.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.domain.order.Tshirt;
import com.sofkau.dddchanllenge.domain.order.values.Completed;

import java.util.List;

public class OrderCreated extends DomainEvent {

    private final List<Tshirt> tshirts;
    private final Completed completed;

    public OrderCreated(List<Tshirt> tshirts) {
        super("mateocardona.order.ordercreated");
        this.tshirts = tshirts;
        this.completed = new Completed();
    }

    public List<Tshirt> getTshirts() {
        return tshirts;
    }

    public Completed getCompleted() {
        return completed;
    }
}
