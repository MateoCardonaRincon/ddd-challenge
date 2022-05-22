package com.sofkau.dddchanllenge.domain.invoice.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Prepayment implements ValueObject<Double> {
    private final Double value;

    public Prepayment(Double value) {
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
        Prepayment that = (Prepayment) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
