package com.woowa.rentcar.domain;

public class SonataCreator implements CarCreator {
    @Override
    public Car create(int distance) {
        return new Sonata(distance);
    }
}
