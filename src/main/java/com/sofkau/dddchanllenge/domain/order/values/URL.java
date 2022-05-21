package com.sofkau.dddchanllenge.domain.order.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class URL implements ValueObject<String> {

    private final String value;

    public URL(String value) {
        Objects.requireNonNull(value);
        if (!value.startsWith("https://")){
            throw new IllegalStateException("The design URL must start with https://");
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
        URL url = (URL) o;
        return Objects.equals(value, url.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
