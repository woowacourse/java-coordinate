package rentcompany;

public abstract class Car implements Vehicle {
    private int distancePerLiter;
    private int tripDistance;

    public Car(int tripDistance, int distancePerLiter) {
        this.tripDistance = tripDistance;
        this.distancePerLiter = distancePerLiter;
    }

    /**
     * 차종의 이름
     */
    @Override
    public abstract String getName();

    /**
     * 주입해야 할 연료량을 구한다.
     */
    @Override
    public double getChargeQuantity() {
        return tripDistance / distancePerLiter;
    }
}
