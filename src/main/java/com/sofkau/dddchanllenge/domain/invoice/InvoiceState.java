package com.sofkau.dddchanllenge.domain.invoice;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.dddchanllenge.domain.invoice.values.InvoiceStateId;
import com.sofkau.dddchanllenge.domain.invoice.values.Payed;
import com.sofkau.dddchanllenge.domain.invoice.values.Prepayment;

public class InvoiceState extends Entity<InvoiceStateId> {

    private Payed isPayed;
    private final Prepayment prepayment;

    public InvoiceState(InvoiceStateId entityId, Payed isPayed, Prepayment prepayment) {
        super(entityId);
        this.isPayed = isPayed;
        this.prepayment = prepayment;
    }

    public void completePayment(){
        this.isPayed = Payed.pay();
    }

    public Payed payed() {
        return isPayed;
    }

    public Prepayment prepayment() {
        return prepayment;
    }
}
