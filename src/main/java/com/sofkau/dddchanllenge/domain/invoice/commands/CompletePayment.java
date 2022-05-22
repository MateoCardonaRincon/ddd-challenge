package com.sofkau.dddchanllenge.domain.invoice.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddchanllenge.domain.invoice.values.Payed;
import com.sofkau.dddchanllenge.domain.shared.values.InvoiceId;

public class CompletePayment extends Command {

    private final InvoiceId invoiceId;
    private final Payed payed;

    public CompletePayment(InvoiceId invoiceId) {
        this.invoiceId = invoiceId;
        this.payed = Payed.pay();
    }

    public InvoiceId getInvoiceId() {
        return invoiceId;
    }

    public Payed getPayed() {
        return payed;
    }
}
