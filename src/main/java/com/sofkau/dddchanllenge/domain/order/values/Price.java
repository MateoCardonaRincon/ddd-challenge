package com.sofkau.dddchanllenge.domain.order.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Price implements ValueObject<Integer> {

    private final Integer value;

    public Price(Integer value) {
        Objects.requireNonNull(value);
        if (value < 0) {
            throw new IllegalStateException("The price cannot be a negative value");
        }
        this.value = value;
    }

    @Override
    public Integer value() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Objects.equals(value, price.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
