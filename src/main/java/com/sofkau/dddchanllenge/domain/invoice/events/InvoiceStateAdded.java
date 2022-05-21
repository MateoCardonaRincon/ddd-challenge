package com.sofkau.dddchanllenge.domain.invoice.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.domain.invoice.values.InvoiceStateId;
import com.sofkau.dddchanllenge.domain.invoice.values.Payed;
import com.sofkau.dddchanllenge.domain.invoice.values.Prepayment;

public class InvoiceStateAdded extends DomainEvent {
    private final InvoiceStateId invoiceStateId;
    private final Payed isPayed;
    private final Prepayment prepayment;

    public InvoiceStateAdded(InvoiceStateId invoiceStateId, Payed isPayed, Prepayment prepayment) {
        super("mateocardona.invoice.invoicestateadded");
        this.invoiceStateId = invoiceStateId;
        this.isPayed = isPayed;
        this.prepayment = prepayment;
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
