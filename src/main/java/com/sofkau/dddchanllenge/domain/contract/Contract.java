package com.sofkau.dddchanllenge.domain.contract;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.domain.contract.values.ClientId;
import com.sofkau.dddchanllenge.domain.contract.values.StamperId;
import com.sofkau.dddchanllenge.domain.contract.values.DateOfContract;
import com.sofkau.dddchanllenge.domain.contract.events.*;
import com.sofkau.dddchanllenge.domain.shared.values.ContractId;
import com.sofkau.dddchanllenge.domain.contract.values.ContactNumber;
import com.sofkau.dddchanllenge.domain.contract.values.Name;
import com.sofkau.dddchanllenge.domain.shared.values.OrderId;

import java.util.List;
import java.util.Objects;

public class Contract extends AggregateEvent<ContractId> {

    protected DateOfContract dateOfContract;
    protected Client client;
    protected Stamper stamper;
    protected OrderId orderId;

    public Contract(ContractId entityId, DateOfContract dateOfContract) {
        super(entityId);
        appendChange(new ContractCreated(dateOfContract)).apply();
    }

    private Contract(ContractId entityId) {
        super(entityId);
        subscribe(new ContractChange(this));
    }

    // re-building the aggregate based on the associated events
    public static Contract from(ContractId contractId, List<DomainEvent> events) {
        Contract contract = new Contract(contractId);
        events.forEach(contract::applyEvent);
        return contract;
    }

    // Behaviors
    public void changeDateOfContract(DateOfContract dateOfContract) {
        Objects.requireNonNull(dateOfContract);
        appendChange(new DateOfContractChanged(dateOfContract)).apply();
    }

    public void addClient(ClientId clientId, Name name, ContactNumber contactNumber) {
        Objects.requireNonNull(clientId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(contactNumber);
        appendChange(new ClientAdded(clientId, name, contactNumber)).apply();
    }

    public void addStamper(StamperId stamperId, Name name, ContactNumber contactNumber){
        Objects.requireNonNull(stamperId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(contactNumber);
        appendChange(new StamperAdded(stamperId, name, contactNumber)).apply();
    }

    public void changeClientName(Name name){
        Objects.requireNonNull(name);
        appendChange(new ClientNameChanged(name)).apply();
    }

    public void changeClientContactNumber(ContactNumber contactNumber){
        Objects.requireNonNull(contactNumber);
        appendChange(new ClientContactNumberChanged(contactNumber)).apply();
    }

    public void changeStamperName(Name name){
        Objects.requireNonNull(name);
        appendChange(new StamperNameChanged(name)).apply();
    }

    public void changeStamperContactNumber(ContactNumber contactNumber){
        Objects.requireNonNull(contactNumber);
        appendChange(new StamperContactNumberChanged(contactNumber)).apply();
    }

    // Getters
    public DateOfContract dateOfContract() {
        return dateOfContract;
    }

    public Client client() {
        return client;
    }

    public Stamper stamper() {
        return stamper;
    }

    public OrderId orderId() {
        return orderId;
    }
}
