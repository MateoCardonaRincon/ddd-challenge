package com.sofkau.dddchanllenge.domain.order.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Completed implements ValueObject<Boolean> {

    private final Boolean value;

    public Completed() {
        this.value = false;
    }

    private Completed(Boolean value){
        this.value = value;
    }

    public static Completed complete(){
        return new Completed(true);
    }

    @Override
    public Boolean value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Completed completed = (Completed) o;
        return Objects.equals(value, completed.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
