package com.sofkau.dddchanllenge.domain.invoice.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Amount implements ValueObject<Double> {
    private final Double value;

    public Amount(Double value) {
        Objects.requireNonNull(value);
        if (value < 0) {
            throw new IllegalArgumentException("The amount can't be a negative value");
        }
        this.value = value;
    }

    @Override
    public Double value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return Objects.equals(value, amount.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
