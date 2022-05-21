package com.sofkau.dddchanllenge.domain.invoice.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddchanllenge.domain.shared.values.InvoiceId;

public class CompletePayment extends Command {

    private final InvoiceId invoiceId;

    public CompletePayment(InvoiceId invoiceId) {
        this.invoiceId = invoiceId;
    }

    public InvoiceId getInvoiceId() {
        return invoiceId;
    }
}
