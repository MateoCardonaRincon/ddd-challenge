package com.sofkau.dddchanllenge.domain.order;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.dddchanllenge.domain.order.values.DesignId;
import com.sofkau.dddchanllenge.domain.order.values.Technique;
import com.sofkau.dddchanllenge.domain.order.values.URL;

import java.util.Objects;

public class Design extends Entity<DesignId> {

    private URL url;
    private Technique technique;

    public Design(DesignId entityId, URL url, Technique technique) {
        super(entityId);
        this.url = url;
        this.technique = technique;
    }

    public void changeDesignURL(URL url){
        this.url = Objects.requireNonNull(url);
    }

    public void changeDesignTechnique(Technique technique){
        this.technique = Objects.requireNonNull(technique);
    }

    public URL url() {
        return url;
    }

    public Technique technique() {
        return technique;
    }
}
