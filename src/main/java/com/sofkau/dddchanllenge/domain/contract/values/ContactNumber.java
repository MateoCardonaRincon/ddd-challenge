package com.sofkau.dddchanllenge.domain.contract.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ContactNumber implements ValueObject<String> {
    private final String value;

    public ContactNumber(String value) {
        Objects.requireNonNull(value);

        if (!value.matches("[0-9]+")) {
            throw new IllegalStateException("The contact number only supports digits");
        }

        if (value.replace(" ", "").length() != 10) {
            throw new IllegalStateException("The contact number must have 10 digits");
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
        ContactNumber that = (ContactNumber) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
