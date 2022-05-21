package com.sofkau.dddchanllenge.domain.order.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Technique implements ValueObject<String> {

    private final String value;

    public Technique(String value) {
        Objects.requireNonNull(value);
        if (value.length() < 3 || value.length() > 50) {
            throw new IllegalStateException("The technique description must be between 3 and 50 characters");
        }
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Technique technique = (Technique) o;
        return Objects.equals(value, technique.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
