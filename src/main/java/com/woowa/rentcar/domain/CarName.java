package com.woowa.rentcar.domain;

import java.util.Objects;

public class CarName {
    private String carName;

    public CarName(String carName) {
        if (validCarName(carName)) {
            throw new IllegalArgumentException("해당 차종은 존재하지 않습니다.");
        }
        this.carName = carName;
    }

    private boolean validCarName(String carName) {
        return !carName.equals("Sonata")
                && !carName.equals("K5")
                && !carName.equals("Avante")
                && !carName.equals("end");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarName carName1 = (CarName) o;
        return Objects.equals(carName, carName1.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName);
    }
}
