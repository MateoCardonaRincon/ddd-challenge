package com.sofkau.dddchanllenge.domain.order;

import co.com.sofka.domain.generic.EventChange;
import com.sofkau.dddchanllenge.domain.order.events.*;

import java.util.ArrayList;

public class OrderChange extends EventChange {

    public OrderChange(Order order) {

        apply((OrderCreated event) -> {
            order.orderCompleted = event.getCompleted();
            order.dateOfOrder = event.getDateOfOrder();
            order.tshirts = new ArrayList<>();
        });

        apply((OrderCompleted event) -> {
            order.orderCompleted = event.getCompleted();
        });

        apply((TshirtAdded event) -> {
            order.tshirts.add(new Tshirt(event.getTshirtId(), event.getPrice()));
        });

        apply((DesignAdded event) -> {
            order.design = new Design(event.getDesignId(), event.getUrl(), event.getTechnique());
        });

        apply((TshirtCheckedAsDone event) -> {
            var tshirt = order.getTshirtById(event.getTshirtId())
                    .orElseThrow(() ->
                            new IllegalArgumentException("No t-shirt with the specified id was found"));
            tshirt.checkTshirtAsDone();
        });

        apply((TshirtPriceEstablished event) -> {
            var tshirt = order.getTshirtById(event.getTshirtId())
                    .orElseThrow(() ->
                            new IllegalArgumentException("No t-shirt with the specified id was found"));
            tshirt.establishTshirtPrice(event.getPrice());
        });

        apply((DesignURLChanged event) -> {
            order.design.changeDesignURL(event.getUrl());
        });

        apply((DesignTechniqueChanged event) -> {
            order.design.changeDesignTechnique(event.getTechnique());
        });
    }
}
