package com.sofkau.dddchanllenge.domain.order.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.domain.order.values.DateOfOrder;

public class DateOfOrderChanged extends DomainEvent {

    private final DateOfOrder dateOfOrder;

    public DateOfOrderChanged(DateOfOrder dateOfOrder) {
        super("mateocardona.order.dateoforderchanged");
        this.dateOfOrder = dateOfOrder;
    }

    public DateOfOrder getDateOfOrder() {
        return dateOfOrder;
    }
}
