package com.sofkau.dddchanllenge.domain.order.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Done implements ValueObject<Boolean> {

    private final Boolean value;

    public Done() {
        this.value = false;
    }

    private Done(Boolean value){
        this.value = value;
    }

    public static Done check(){
        return new Done(true);
    }

    @Override
    public Boolean value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Done done = (Done) o;
        return Objects.equals(value, done.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
