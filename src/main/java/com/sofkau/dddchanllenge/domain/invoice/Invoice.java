package com.sofkau.dddchanllenge.domain.invoice;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.dddchanllenge.domain.invoice.events.*;
import com.sofkau.dddchanllenge.domain.invoice.values.*;
import com.sofkau.dddchanllenge.domain.shared.values.InvoiceId;
import com.sofkau.dddchanllenge.domain.shared.values.OrderId;

import java.util.List;
import java.util.Objects;

public class Invoice extends AggregateEvent<InvoiceId> {

    protected InvoiceDate invoiceDate;
    protected PaymentDate paymentDate;
    protected InvoiceState state;
    protected PaymentMethod paymentMethod;
    protected OrderId orderId;

    public Invoice(InvoiceId invoiceId, InvoiceDate invoiceDate, OrderId orderId) {
        super(invoiceId);
        this.invoiceDate = invoiceDate;
        this.orderId = orderId;
        appendChange(new InvoiceCreated(invoiceDate, orderId)).apply();
    }

    private Invoice(InvoiceId invoiceId) {
        super(invoiceId);
        subscribe(new InvoiceChange(this));
    }

    // re-building the aggregate based on the associated events
    public static Invoice from(InvoiceId invoiceId, List<DomainEvent> events) {
        Invoice invoice = new Invoice(invoiceId);
        events.forEach(invoice::applyEvent);
        return invoice;
    }

    // Behaviors
    public void addPaymentMethod(PaymentMethodId paymentMethodId, Description description, Amount amount) {
        Objects.requireNonNull(paymentMethodId);
        Objects.requireNonNull(description);
        Objects.requireNonNull(amount);
        appendChange(new PaymentMethodAdded(paymentMethodId, description, amount)).apply();
    }

    public void addInvoiceState(InvoiceStateId invoiceStateId, Payed isPayed, Prepayment prepayment) {
        Objects.requireNonNull(invoiceStateId);
        Objects.requireNonNull(isPayed);
        Objects.requireNonNull(prepayment);
        appendChange(new InvoiceStateAdded(invoiceStateId, isPayed, prepayment)).apply();
    }

    public void establishPaymentDate() {
        appendChange(new PaymentDateEstablished()).apply();
    }

    public void completePayment() {
        appendChange(new PaymentCompleted()).apply();
    }

    public void changePaymentDescription(Description description) {
        Objects.requireNonNull(description);
        appendChange(new PaymentDescriptionChanged(description)).apply();
    }

    public void changePaymentAmount(Amount amount) {
        Objects.requireNonNull(orderId);
        appendChange(new PaymentAmountChanged(amount)).apply();
    }

    public InvoiceDate invoiceDate() {
        return invoiceDate;
    }

    public PaymentDate paymentDate() {
        return paymentDate;
    }

    public InvoiceState state() {
        return state;
    }

    public PaymentMethod paymentMethod() {
        return paymentMethod;
    }

    public OrderId orderId() {
        return orderId;
    }
}
