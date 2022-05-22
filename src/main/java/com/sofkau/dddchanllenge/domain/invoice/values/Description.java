package com.sofkau.dddchanllenge.domain.invoice.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Description implements ValueObject<String> {
    private final String value;

    public Description(String value) {
        Objects.requireNonNull(value);
        if(value.length() > 100){
            throw new IllegalArgumentException("The description only allows a maximum of 100 character");
        }
        if(value.isBlank()){
            throw new IllegalArgumentException("Please enter a valid description, not an empty one");
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
        Description that = (Description) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
