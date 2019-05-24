package com.woowa.rentcar.domain;

import java.util.HashMap;
import java.util.Map;

public class CarFactory {
    private final static Map<String, CarCreator> map;

    static {
        map = new HashMap<>();
        map.put("Sonata", new SonataCreator());
        map.put("Avante", new AvanteCreator());
        map.put("K5", new K5Creator());
    }

    public static Car newInstance(String carName, Distance distance) {
        try {
            return map.get(carName).create(distance);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("해당 차는 존재하지 않습니다");
        }
    }
}
