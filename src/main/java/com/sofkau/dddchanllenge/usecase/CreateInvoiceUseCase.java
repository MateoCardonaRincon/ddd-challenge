package com.sofkau.dddchanllenge.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkau.dddchanllenge.domain.invoice.Invoice;
import com.sofkau.dddchanllenge.domain.invoice.values.InvoiceDate;
import com.sofkau.dddchanllenge.domain.invoice.values.InvoiceStateId;
import com.sofkau.dddchanllenge.domain.invoice.values.Payed;
import com.sofkau.dddchanllenge.domain.invoice.values.Prepayment;
import com.sofkau.dddchanllenge.domain.order.events.OrderCreated;
import com.sofkau.dddchanllenge.domain.shared.values.InvoiceId;
import com.sofkau.dddchanllenge.domain.shared.values.OrderId;

public class CreateInvoiceUseCase extends UseCase<TriggeredEvent<OrderCreated>, ResponseEvents> {

    // An invoice is created with an initial payment 20% of the total cost of the order
    private final Double initialPaymentPercentage = 0.2;

    @Override
    public void executeUseCase(TriggeredEvent<OrderCreated> orderCreatedTriggeredEvent) {

        var event = orderCreatedTriggeredEvent.getDomainEvent();

        var totalCostOfOrder = event.getTshirts().stream()
                .map(tshirt -> tshirt.price().value())
                .reduce(0., Double::sum);

        var invoice = new Invoice(
                new InvoiceId(),
                new InvoiceDate(event.getDateOfOrder().value()),
                OrderId.of(event.aggregateRootId())
                );

        invoice.addInvoiceState(
                new InvoiceStateId(),
                new Payed(),
                new Prepayment(totalCostOfOrder * initialPaymentPercentage));

        emit().onResponse(new ResponseEvents(invoice.getUncommittedChanges()));
    }
}
