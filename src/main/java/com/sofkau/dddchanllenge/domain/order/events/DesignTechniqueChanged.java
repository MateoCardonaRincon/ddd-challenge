package com.sofkau.dddchanllenge.domain.order.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.domain.order.values.Technique;

public class DesignTechniqueChanged extends DomainEvent {
    private final Technique technique;

    public DesignTechniqueChanged(Technique technique) {
        super("mateocardona.order.designtechniquechanged");
        this.technique = technique;
    }

    public Technique getTechnique() {
        return technique;
    }
}
