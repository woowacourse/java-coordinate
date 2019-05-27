package fuel.domain;

public class K5 extends AbstractCar {
    private static final int FUEL_EFFICIENCY_VALUE = 13;
    private static final String CAR_NAME = "K5";

    public K5(final int distance) {
        super.distance = distance;
        super.fuelEfficiency = FUEL_EFFICIENCY_VALUE;
    }

    @Override
    public String getName() {
        return CAR_NAME;
    }

}
