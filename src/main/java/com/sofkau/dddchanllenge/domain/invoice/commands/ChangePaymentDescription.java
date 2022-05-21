package com.sofkau.dddchanllenge.domain.invoice.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddchanllenge.domain.invoice.values.Description;
import com.sofkau.dddchanllenge.domain.shared.values.InvoiceId;

public class ChangePaymentDescription extends Command {

    private final InvoiceId invoiceId;
    private final Description description;

    public ChangePaymentDescription(InvoiceId invoiceId, Description description) {
        this.invoiceId = invoiceId;
        this.description = description;
    }

    public InvoiceId getInvoiceId() {
        return invoiceId;
    }

    public Description getDescription() {
        return description;
    }
}
