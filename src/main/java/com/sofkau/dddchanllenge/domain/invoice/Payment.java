package com.sofkau.dddchanllenge.domain.invoice;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.dddchanllenge.domain.invoice.values.Amount;
import com.sofkau.dddchanllenge.domain.invoice.values.PaymentId;
import com.sofkau.dddchanllenge.domain.invoice.values.PaymentMethod;

import java.lang.reflect.Method;
import java.util.Objects;

public class Payment extends Entity<PaymentId> {

    private PaymentMethod method;
    private Amount amount;

    public Payment(PaymentId entityId, PaymentMethod method, Amount amount) {
        super(entityId);
        this.method = method;
        this.amount = amount;
    }

    public void changePaymentMethod(PaymentMethod method){
        this.method = Objects.requireNonNull(method);
    }

    public void changePaymentAmount(Amount amount){
        this.amount = Objects.requireNonNull(amount);
    }

    public PaymentMethod method() {
        return method;
    }

    public Amount amount() {
        return amount;
    }
}
