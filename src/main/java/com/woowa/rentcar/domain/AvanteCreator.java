package com.woowa.rentcar.domain;

public class AvanteCreator implements CarCreator {
    @Override
    public Car create(Distance distance) {
        return new Avante(distance);
    }
}
