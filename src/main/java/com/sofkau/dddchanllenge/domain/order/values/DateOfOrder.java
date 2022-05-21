package com.sofkau.dddchanllenge.domain.order.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDateTime;
import java.util.Objects;

public class DateOfOrder  implements ValueObject<LocalDateTime> {

    private final LocalDateTime value;

    public DateOfOrder(LocalDateTime value) {
        Objects.requireNonNull(value);
        if (value.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("The date of the order must be later than the current date");
        }
        this.value = value;
    }

    @Override
    public LocalDateTime value() {
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
