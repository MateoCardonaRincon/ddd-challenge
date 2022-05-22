package com.sofkau.dddchanllenge.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkau.dddchanllenge.domain.contract.Contract;
import com.sofkau.dddchanllenge.domain.contract.Stamper;
import com.sofkau.dddchanllenge.domain.contract.values.ContactNumber;
import com.sofkau.dddchanllenge.domain.contract.values.DateOfContract;
import com.sofkau.dddchanllenge.domain.contract.values.Name;
import com.sofkau.dddchanllenge.domain.contract.values.StamperId;
import com.sofkau.dddchanllenge.domain.order.events.OrderCreated;
import com.sofkau.dddchanllenge.domain.shared.values.ContractId;

public class CreateContractUseCase extends UseCase<TriggeredEvent<OrderCreated>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<OrderCreated> orderCreatedTriggeredEvent) {
        var event = orderCreatedTriggeredEvent.getDomainEvent();

        var contract = new Contract(
                new ContractId(),
                new DateOfContract(event.getDateOfOrder().value())
        );

        // adding a default stamper
        contract.addStamper(
                StamperId.of("default123"),
                new Name("Mateo"),
                new ContactNumber("3147781255"));

        emit().onResponse(new ResponseEvents(contract.getUncommittedChanges()));
    }
}
