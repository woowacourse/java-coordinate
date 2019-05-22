package rantCar.domain;

public abstract class RentCar implements Car {
    private final String NAME;
    private final int DISTANCE_PER_LITER;
    private final int TRIP_DISTANCE;

    RentCar(String name, int distancePErLiter, int tripDistance) {
        this.NAME = name;
        this.DISTANCE_PER_LITER = distancePErLiter;
        this.TRIP_DISTANCE = tripDistance;
    }
    /**
     * 차종의 이름
     */
    public String getName() {
        return this.NAME;
    }

    /**
     * 주입해야할 연료량을 구한다.
     */
    public double getChargeQuantity() {
        return TRIP_DISTANCE / DISTANCE_PER_LITER;
    }
}
