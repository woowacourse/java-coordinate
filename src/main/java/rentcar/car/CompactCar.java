package rentcar.car;

public abstract class CompactCar implements Car {
    private final String carName;
    private final int distancePerLiter;
    private final int tripDistance;

    CompactCar(String carName, int distancePerLiter, int tripDistance) {
        this.distancePerLiter = distancePerLiter;
        this.carName = carName;
        this.tripDistance = tripDistance;
    }

    @Override
    public String getName() {
        return carName;
    }

    @Override
    public double getChargeQuantity() {
        return tripDistance / distancePerLiter;
    }
}
