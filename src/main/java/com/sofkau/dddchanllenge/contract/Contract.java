package com.sofkau.dddchanllenge.contract;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.contract.events.ContractCreated;
import com.sofkau.dddchanllenge.contract.values.ContractId;
import com.sofkau.dddchanllenge.contract.values.DateOfContract;
import com.sofkau.dddchanllenge.values.ContactNumber;
import com.sofkau.dddchanllenge.values.Name;

import java.util.List;

public class Contract extends AggregateEvent<ContractId> {

    protected DateOfContract dateOfContract;
    protected Client client;
    protected Stamper stamper;

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

    public void addClient(Name name, ContactNumber contactNumber){
//        this.client = new Client(name, contactNumber)
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
