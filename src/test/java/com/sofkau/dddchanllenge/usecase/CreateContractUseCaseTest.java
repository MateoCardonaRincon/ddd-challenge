package com.sofkau.dddchanllenge.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkau.dddchanllenge.domain.contract.Stamper;
import com.sofkau.dddchanllenge.domain.contract.commands.CreateContract;
import com.sofkau.dddchanllenge.domain.contract.events.ContractCreated;
import com.sofkau.dddchanllenge.domain.contract.events.StamperAdded;
import com.sofkau.dddchanllenge.domain.contract.values.ContactNumber;
import com.sofkau.dddchanllenge.domain.contract.values.DateOfContract;
import com.sofkau.dddchanllenge.domain.contract.values.Name;
import com.sofkau.dddchanllenge.domain.contract.values.StamperId;
import com.sofkau.dddchanllenge.domain.invoice.events.InvoiceCreated;
import com.sofkau.dddchanllenge.domain.invoice.events.InvoiceStateAdded;
import com.sofkau.dddchanllenge.domain.invoice.values.Payed;
import com.sofkau.dddchanllenge.domain.order.events.OrderCreated;
import com.sofkau.dddchanllenge.domain.order.values.DateOfOrder;
import com.sofkau.dddchanllenge.domain.shared.values.ContractId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

class CreateContractUseCaseTest {

    private final String ROOTID = "11111";

    @Test
    void createContract() {

        Stamper defaultStamper = new Stamper(
                StamperId.of("default123"),
                new Name("Mateo"),
                new ContactNumber("3147781255"));

        DateOfOrder orderDate = new DateOfOrder(LocalDate.now());

        var event = new OrderCreated(orderDate);

        event.setAggregateRootId(ROOTID);

        var useCase = new CreateContractUseCase();

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow(() -> new IllegalArgumentException("The contract could not be created"))
                .getDomainEvents();

        var contractCreatedEvent = (ContractCreated) events.get(0);

        var stamperAddedEvent = (StamperAdded) events.get(1);

        Assertions.assertEquals(orderDate.value(), contractCreatedEvent.getDateOfContract().value());
        Assertions.assertEquals(defaultStamper.name().value(), stamperAddedEvent.getName().value());
        Assertions.assertEquals(defaultStamper.contactNumber().value(), stamperAddedEvent.getContactNumber().value());
    }
}