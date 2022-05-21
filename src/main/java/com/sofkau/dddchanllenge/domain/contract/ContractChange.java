package com.sofkau.dddchanllenge.domain.contract;

import co.com.sofka.domain.generic.EventChange;
import com.sofkau.dddchanllenge.domain.contract.values.ClientId;
import com.sofkau.dddchanllenge.domain.contract.values.StamperId;
import com.sofkau.dddchanllenge.domain.contract.events.*;
import com.sofkau.dddchanllenge.domain.shared.values.ContactNumber;
import com.sofkau.dddchanllenge.domain.shared.values.Name;

public class ContractChange extends EventChange {

    public ContractChange(Contract contract) {
        apply((ContractCreated event) -> {
            contract.dateOfContract = event.getDateOfContract();
        });

        apply((OrderAssociatedToContract event) -> {
            contract.orderId = event.getOrderId();
        });

        apply((DateOfContractChanged event) -> {
            contract.dateOfContract = event.getDateOfContract();
        });

        apply((ClientAdded event) -> {
            ClientId clientId = event.getClientId();
            Name name = event.getName();
            ContactNumber contactNumber = event.getContactNumber();
            contract.client = new Client(clientId, name, contactNumber);
        });

        apply((StamperAdded event) -> {
            StamperId stamperId = event.getStamperId();
            Name name = event.getName();
            ContactNumber contactNumber = event.getContactNumber();
            contract.stamper = new Stamper(stamperId, name, contactNumber);
        });

        apply((ClientNameChanged event) -> {
            contract.client.changeClientName(event.getName());
        });

        apply((ClientContactNumberChanged event) -> {
            contract.client.changeClientContactNumber(event.getContactNumber());
        });

        apply((StamperNameChanged event) -> {
            contract.stamper.changeStamperName(event.getName());
        });

        apply((StamperContactNumberChanged event) -> {
            contract.stamper.changeStamperContactNumber(event.getContactNumber());
        });
    }
}
