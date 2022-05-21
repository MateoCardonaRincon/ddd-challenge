package com.sofkau.dddchanllenge.domain.invoice.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddchanllenge.domain.invoice.values.InvoiceStateId;
import com.sofkau.dddchanllenge.domain.invoice.values.Payed;
import com.sofkau.dddchanllenge.domain.invoice.values.Prepayment;
import com.sofkau.dddchanllenge.domain.shared.values.InvoiceId;

public class AddInvoiceState extends Command {

    private final InvoiceId invoiceId;
    private final InvoiceStateId invoiceStateId;
    private final Payed isPayed;
    private final Prepayment prepayment;

    public AddInvoiceState(InvoiceId invoiceId, InvoiceStateId invoiceStateId, Payed isPayed, Prepayment prepayment) {
        this.invoiceId = invoiceId;
        this.invoiceStateId = invoiceStateId;
        this.isPayed = isPayed;
        this.prepayment = prepayment;
    }

    public InvoiceId getInvoiceId() {
        return invoiceId;
    }

    public InvoiceStateId getInvoiceStateId() {
        return invoiceStateId;
    }

    public Payed getIsPayed() {
        return isPayed;
    }

    public Prepayment getPrepayment() {
        return prepayment;
    }
}
