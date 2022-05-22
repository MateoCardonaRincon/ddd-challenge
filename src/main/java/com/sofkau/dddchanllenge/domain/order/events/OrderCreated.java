package com.sofkau.dddchanllenge.domain.order.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.domain.order.Tshirt;
import com.sofkau.dddchanllenge.domain.order.values.Completed;
import com.sofkau.dddchanllenge.domain.order.values.DateOfOrder;

import java.util.ArrayList;
import java.util.List;

public class OrderCreated extends DomainEvent {

    private final DateOfOrder dateOfOrder;
    private final Completed completed;
    private final List<Tshirt> tshirts;

    public OrderCreated(DateOfOrder dateOfOrder) {
        super("mateocardona.order.ordercreated");
        this.completed = new Completed();
        this.dateOfOrder = dateOfOrder;
        this.tshirts = new ArrayList<>();
    }

    public List<Tshirt> getTshirts() {
        return tshirts;
    }

    public DateOfOrder getDateOfOrder() {
        return dateOfOrder;
    }

    public Completed getCompleted() {
        return completed;
    }

}
