package com.sofkau.dddchanllenge.domain.invoice.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddchanllenge.domain.invoice.values.InvoiceDate;
import com.sofkau.dddchanllenge.domain.shared.values.InvoiceId;
import com.sofkau.dddchanllenge.domain.shared.values.OrderId;

public class CreateInvoice extends Command {

    private final InvoiceId invoiceId;
    private final InvoiceDate invoiceDate;
    private final OrderId orderId;

    public CreateInvoice(InvoiceId invoiceId, InvoiceDate invoiceDate, OrderId orderId) {
        this.invoiceId = invoiceId;
        this.invoiceDate = invoiceDate;
        this.orderId = orderId;
    }

    public InvoiceId getInvoiceId() {
        return invoiceId;
    }

    public InvoiceDate getInvoiceDate() {
        return invoiceDate;
    }

    public OrderId getOrderId() {
        return orderId;
    }
}
