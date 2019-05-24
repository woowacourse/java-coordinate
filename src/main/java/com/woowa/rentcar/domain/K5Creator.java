package com.woowa.rentcar.domain;

public class K5Creator implements CarCreator {
    @Override
    public Car create(int distance) {
        return new K5(distance);
    }
}
