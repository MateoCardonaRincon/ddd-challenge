package com.sofkau.dddchanllenge.domain.invoice.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Objects;

public class InvoiceDate implements ValueObject<LocalDate> {

    private final LocalDate value;

    public InvoiceDate(LocalDate value) {
        Objects.requireNonNull(value);
        if (value.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("The date of the invoice can't be earlier than the current date");
        }
        this.value = value;
    }

    @Override
    public LocalDate value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceDate that = (InvoiceDate) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
