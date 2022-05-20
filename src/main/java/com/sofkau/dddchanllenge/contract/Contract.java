package com.sofkau.dddchanllenge.contract;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.contract.events.ClientAdded;
import com.sofkau.dddchanllenge.contract.events.ContractCreated;
import com.sofkau.dddchanllenge.contract.values.ClientId;
import com.sofkau.dddchanllenge.values.ContractId;
import com.sofkau.dddchanllenge.contract.values.DateOfContract;
import com.sofkau.dddchanllenge.values.ContactNumber;
import com.sofkau.dddchanllenge.values.Name;
import com.sofkau.dddchanllenge.values.OrderId;

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

    // re-build the aggregate based on the associated events
    public static Contract from(ContractId contractId, List<DomainEvent> events){
        Contract contract = new Contract(contractId);
        events.forEach(contract::applyEvent);
        return contract;
    }

    public void addClient(ClientId entityId, Name name, ContactNumber contactNumber){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(name);
        Objects.requireNonNull(contactNumber);
        appendChange(new ClientAdded(entityId, name, contactNumber));
    }



    public DateOfContract dateOfContract() {
        return dateOfContract;
    }

    public Client client() {
        return client;
    }

    public Stamper stamper() {
        return stamper;
    }
}
