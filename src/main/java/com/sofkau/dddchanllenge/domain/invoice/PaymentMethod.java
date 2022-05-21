package com.sofkau.dddchanllenge.domain.invoice;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.dddchanllenge.domain.invoice.values.Amount;
import com.sofkau.dddchanllenge.domain.invoice.values.Description;
import com.sofkau.dddchanllenge.domain.invoice.values.PaymentMethodId;

import java.util.Objects;

public class PaymentMethod extends Entity<PaymentMethodId> {

    private Description description;
    private Amount amount;

    public PaymentMethod(PaymentMethodId paymentMethodId, Description description, Amount amount) {
        super(paymentMethodId);
        this.description = description;
        this.amount = amount;
    }

    public void changePaymentDescription(Description description){
        this.description = Objects.requireNonNull(description);
    }

    public void changePaymentAmount(Amount amount){
        this.amount = Objects.requireNonNull(amount);
    }

    public Description description() {
        return description;
    }

    public Amount amount() {
        return amount;
    }
}
