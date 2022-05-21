package com.sofkau.dddchanllenge.domain.order.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.domain.order.values.Done;
import com.sofkau.dddchanllenge.domain.order.values.TshirtId;

public class TshirtCheckedAsDone extends DomainEvent {
    private final Done done;
    private final TshirtId tshirtId;

    public TshirtCheckedAsDone(TshirtId tshirtId) {
        super("mateocardona.order.tshirtcheckedasdone");
        this.tshirtId = tshirtId;
        this.done = Done.check();
    }

    public Done getDone() {
        return done;
    }

    public TshirtId getTshirtId() {
        return tshirtId;
    }
}
