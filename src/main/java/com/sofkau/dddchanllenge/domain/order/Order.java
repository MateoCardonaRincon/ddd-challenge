package com.sofkau.dddchanllenge.domain.order;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.domain.order.events.*;
import com.sofkau.dddchanllenge.domain.order.values.*;
import com.sofkau.dddchanllenge.domain.shared.values.OrderId;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Order extends AggregateEvent<OrderId> {

    protected Completed orderCompleted;
    protected List<Tshirt> tshirts;
    protected Design design;

    public Order(OrderId entityId, List<Tshirt> tshirts) {
        super(entityId);
        appendChange(new OrderCreated(tshirts)).apply();
    }

    private Order(OrderId entityId) {
        super(entityId);
        subscribe(new OrderChange(this));
    }

    // re-building the aggregate based on the associated events
    public static Order from(OrderId orderId, List<DomainEvent> events) {
        Order order = new Order(orderId);
        events.forEach(order::applyEvent);
        return order;
    }

    // behaviors
    public void completeOrder() {
        appendChange(new OrderCompleted());
    }

    public void addTshirt(TshirtId tshirtId, Price price) {
        Objects.requireNonNull(tshirtId);
        Objects.requireNonNull(price);
        appendChange(new TshirtAdded(tshirtId, price));
    }

    public void addDesign(DesignId designId, URL url, Technique technique){
        Objects.requireNonNull(designId);
        Objects.requireNonNull(url);
        Objects.requireNonNull(technique);
        appendChange(new DesignAdded(designId, url, technique));
    }

    public void checkTshirtAsDone(TshirtId tshirtId){
        appendChange(new TshirtCheckedAsDone(tshirtId));
    }

    public void establishTshirtPrice(TshirtId tshirtId, Price price){
        Objects.requireNonNull(tshirtId);
        Objects.requireNonNull(price);
        appendChange(new TshirtPriceEstablished(tshirtId, price));
    }

    public void changeDesignURL(URL url){
        Objects.requireNonNull(url);
        appendChange(new DesignURLChanged(url));
    }

    public void changeDesignTechnique(Technique technique){
        Objects.requireNonNull(technique);
        appendChange(new DesignTechniqueChanged(technique));
    }

    // helpers
    public Optional<Tshirt> getTshirtById(TshirtId tshirtId){
        return tshirts.stream().filter(tshirt -> tshirt.identity().equals(tshirtId)).findFirst();
    }

    // Getters
    public Completed orderCompleted() {
        return orderCompleted;
    }

    public List<Tshirt> tshirts() {
        return tshirts;
    }

    public Design design() {
        return design;
    }
}
