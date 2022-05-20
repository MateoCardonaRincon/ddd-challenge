package com.sofkau.dddchanllenge.domain.contract.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDateTime;
import java.util.Objects;

public class DateOfContract implements ValueObject<LocalDateTime> {
    private final LocalDateTime value;

    public DateOfContract(LocalDateTime value) {
        Objects.requireNonNull(value);

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
        DateOfContract that = (DateOfContract) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }


}
