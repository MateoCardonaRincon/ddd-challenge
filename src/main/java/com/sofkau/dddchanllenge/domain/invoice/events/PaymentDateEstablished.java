package com.sofkau.dddchanllenge.domain.invoice.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.domain.invoice.values.InvoiceDate;

import java.time.LocalDate;

public class PaymentDateEstablished extends DomainEvent {

    private final InvoiceDate invoiceDate;

    public PaymentDateEstablished() {
        super("mateocardona.invoice.paymentdateestablished");
        invoiceDate = new InvoiceDate(LocalDate.now());
    }

    public InvoiceDate getInvoiceDate() {
        return invoiceDate;
    }
}
