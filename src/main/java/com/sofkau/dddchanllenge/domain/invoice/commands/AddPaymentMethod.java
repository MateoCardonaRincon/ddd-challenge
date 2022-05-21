package com.sofkau.dddchanllenge.domain.invoice.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.dddchanllenge.domain.invoice.values.Amount;
import com.sofkau.dddchanllenge.domain.invoice.values.Description;
import com.sofkau.dddchanllenge.domain.invoice.values.PaymentMethodId;
import com.sofkau.dddchanllenge.domain.shared.values.InvoiceId;

public class AddPaymentMethod extends Command {
    private final InvoiceId invoiceId;
    private final PaymentMethodId paymentMethodId;
    private final Description description;
    private final Amount amount;

    public AddPaymentMethod(InvoiceId invoiceId, PaymentMethodId paymentMethodId, Description description, Amount amount) {
        this.invoiceId = invoiceId;
        this.paymentMethodId = paymentMethodId;
        this.description = description;
        this.amount = amount;
    }

    public InvoiceId getInvoiceId() {
        return invoiceId;
    }

    public PaymentMethodId getPaymentMethodId() {
        return paymentMethodId;
    }

    public Description getDescription() {
        return description;
    }

    public Amount getAmount() {
        return amount;
    }
}
