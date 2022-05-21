package com.sofkau.dddchanllenge.domain.order.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.domain.order.values.Completed;

public class OrderCompleted extends DomainEvent {

    private final Completed completed;

    public OrderCompleted() {
        super("mateocardona.order.ordercompleted");
        this.completed = Completed.complete();
    }

    public Completed getCompleted() {
        return completed;
    }
}
