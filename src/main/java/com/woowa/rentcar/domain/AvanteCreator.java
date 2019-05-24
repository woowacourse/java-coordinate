package com.woowa.rentcar.domain;

public class AvanteCreator implements CarCreator {
    @Override
    public Car create(int distance) {
        return new Avante(distance);
    }
}
