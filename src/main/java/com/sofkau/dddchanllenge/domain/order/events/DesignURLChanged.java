package com.sofkau.dddchanllenge.domain.order.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.domain.order.values.URL;

public class DesignURLChanged extends DomainEvent {
    private final URL url;

    public DesignURLChanged(URL url) {
        super("mateocardona.order.designurlchanged");
        this.url = url;
    }

    public URL getUrl() {
        return url;
    }
}
