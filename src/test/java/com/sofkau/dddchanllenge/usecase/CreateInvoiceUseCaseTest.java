package com.sofkau.dddchanllenge.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkau.dddchanllenge.domain.invoice.events.InvoiceCreated;
import com.sofkau.dddchanllenge.domain.invoice.events.InvoiceStateAdded;
import com.sofkau.dddchanllenge.domain.invoice.values.Payed;
import com.sofkau.dddchanllenge.domain.order.events.OrderCreated;
import com.sofkau.dddchanllenge.domain.order.values.DateOfOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
class CreateInvoiceUseCaseTest {

    private final String ROOTID = "12874";

    @Test
    void createInvoiceAtOrderCreation() {

        DateOfOrder orderDate = new DateOfOrder(LocalDate.of(2022, 5, 30));

        var event = new OrderCreated(orderDate);

        event.setAggregateRootId(ROOTID);

        var useCase = new CreateInvoiceUseCase();

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow(() -> new IllegalArgumentException("The invoice could not be created"))
                .getDomainEvents();

        var invoiceCreatedEvent = (InvoiceCreated) events.get(0);
        var invoiceStateAddedEvent = (InvoiceStateAdded) events.get(1);

        Assertions.assertEquals(orderDate.value(), invoiceCreatedEvent.getInvoiceDate().value());
        Assertions.assertEquals(0., invoiceStateAddedEvent.getPrepayment().value());
        Assertions.assertEquals(new Payed().value(), invoiceStateAddedEvent.getIsPayed().value());

    }

}