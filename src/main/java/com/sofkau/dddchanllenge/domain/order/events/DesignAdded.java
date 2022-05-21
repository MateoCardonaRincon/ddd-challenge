package com.sofkau.dddchanllenge.domain.order.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.domain.order.values.DesignId;
import com.sofkau.dddchanllenge.domain.order.values.Technique;
import com.sofkau.dddchanllenge.domain.order.values.URL;

public class DesignAdded extends DomainEvent {
    private final DesignId designId;
    private final URL url;
    private final Technique technique;

    public DesignAdded(DesignId designId, URL url, Technique technique) {
        super("mateocardona.order.designadded");
        this.designId = designId;
        this.url = url;
        this.technique = technique;
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
