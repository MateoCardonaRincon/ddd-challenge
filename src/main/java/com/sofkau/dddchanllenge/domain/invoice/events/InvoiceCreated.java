package com.sofkau.dddchanllenge.domain.invoice.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.domain.invoice.values.InvoiceDate;
import com.sofkau.dddchanllenge.domain.shared.values.OrderId;

public class InvoiceCreated extends DomainEvent {

    private final InvoiceDate invoiceDate;
    private final OrderId orderId;

    public InvoiceCreated(InvoiceDate invoiceDate, OrderId orderId) {
        super("mateocardona.invoice.invoicecreated");
        this.invoiceDate = invoiceDate;
        this.orderId = orderId;
    }

    public InvoiceDate getInvoiceDate() {
        return invoiceDate;
    }

    public OrderId getOrderId() {
        return orderId;
    }
}
