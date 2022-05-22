package com.sofkau.dddchanllenge.domain.invoice.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.domain.invoice.values.InvoiceDate;
import com.sofkau.dddchanllenge.domain.invoice.values.PaymentDate;

import java.time.LocalDate;

public class PaymentDateEstablished extends DomainEvent {

    private final PaymentDate paymentDate;

    public PaymentDateEstablished() {
        super("mateocardona.invoice.paymentdateestablished");
        paymentDate = new PaymentDate(LocalDate.now());
    }

    public PaymentDate getPaymentDate() {
        return paymentDate;
    }
}
