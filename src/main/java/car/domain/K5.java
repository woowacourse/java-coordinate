package car.domain;

public class K5 extends AbstractCar {
    private static final String NAME = "K5";
    private static final double FUEL_EFFICIENCY = 13;

    public K5(double distance) {
        super.distance = distance;
        super.fuelEfficiency = FUEL_EFFICIENCY;
    }

    @Override
    String getName() {
        return NAME;
    }
}
