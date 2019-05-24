package com.woowa.rentcar.domain;

import com.woowa.rentcar.CarName;

import java.util.HashMap;
import java.util.Map;

public class CarFactory {
    private final static Map<CarName, CarCreator> map;

    static {
        map = new HashMap<>();
        map.put(new CarName("Sonata"), new SonataCreator());
        map.put(new CarName("Avante"), new AvanteCreator());
        map.put(new CarName("K5"), new K5Creator());
    }

    public static Car newInstance(CarName carName/*String carName*/, Distance distance) {
        try {
            return map.get(carName).create(distance);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("해당 차는 존재하지 않습니다");
        }
    }
}
