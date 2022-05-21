package com.sofkau.dddchanllenge.domain.invoice.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Payed implements ValueObject<Boolean> {
    private final Boolean value;

    public Payed(Boolean value) {
        this.value = value;
    }

    @Override
    public Boolean value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payed payed = (Payed) o;
        return Objects.equals(value, payed.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
