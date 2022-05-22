package com.sofkau.dddchanllenge.domain.invoice;

import co.com.sofka.domain.generic.EventChange;
import com.sofkau.dddchanllenge.domain.invoice.events.*;
import com.sofkau.dddchanllenge.domain.order.Order;

public class InvoiceChange extends EventChange {

    public InvoiceChange(Invoice invoice) {

        apply((InvoiceCreated event) -> {
            invoice.invoiceDate = event.getInvoiceDate();
            invoice.orderId = event.getOrderId();
        });

        apply((PaymentMethodAdded event) -> {
            invoice.paymentMethod = new PaymentMethod(
                    event.getPaymentMethodId(),
                    event.getDescription(),
                    event.getAmount());
        });

        apply((InvoiceStateAdded event) -> {
            invoice.state = new InvoiceState(
                    event.getInvoiceStateId(),
                    event.getIsPayed(),
                    event.getPrepayment());
        });

        apply((PaymentDateEstablished event) -> {
            invoice.paymentDate = event.getPaymentDate();
        });

        apply((PaymentCompleted event) -> {
            invoice.state.completePayment();
        });

        apply((PaymentDescriptionChanged event) -> {
            invoice.paymentMethod.changePaymentDescription(event.getDescription());
        });

        apply((PaymentAmountChanged event) -> {
            invoice.paymentMethod.changePaymentAmount(event.getAmount());
        });
    }
}
