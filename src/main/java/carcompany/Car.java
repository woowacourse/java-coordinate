package carcompany;

public abstract class Car {
    private final double distancePerLiter;
    private final double tripDistance;

    public Car(final double distancePerLiter,final double tripDistance) {
        this.distancePerLiter = distancePerLiter;
        this.tripDistance = tripDistance;
    }
    /**
     * 차종의 이름
     */
    abstract String getName();

    /**
     * 주입해야할 연료량을 구한다.
     */
    double getChargeQuantity() {
        return tripDistance / distancePerLiter;
    }
}