package com.sofkau.dddchanllenge.domain.invoice.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddchanllenge.domain.shared.values.InvoiceId;
import com.sofkau.dddchanllenge.domain.shared.values.OrderId;

public class ChangePaymentAmount extends Command {
    private final InvoiceId invoiceId;
    private final OrderId orderId;

    public ChangePaymentAmount(InvoiceId invoiceId, OrderId orderId) {
        this.invoiceId = invoiceId;
        this.orderId = orderId;
    }

    public InvoiceId getInvoiceId() {
        return invoiceId;
    }

    public OrderId getOrderId() {
        return orderId;
    }
}
