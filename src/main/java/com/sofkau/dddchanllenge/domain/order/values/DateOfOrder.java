package com.sofkau.dddchanllenge.domain.order.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Objects;

public class DateOfOrder  implements ValueObject<LocalDate> {

    private final LocalDate value;

    public DateOfOrder(LocalDate value) {
        Objects.requireNonNull(value);
        if (value.isBefore(LocalDate.now())) {
            throw new IllegalStateException("The date of the order must be later than the current date");
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
        DateOfOrder that = (DateOfOrder) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
