package fuel.domain;

public class K5 implements Car {
    private static final int FUEL_EFFICIENCY_VALUE = 13;
    private static final String CAR_NAME = "K5";
    private final int distance;

    public K5(final int distance) {
        this.distance = distance;
    }

    @Override
    public int getDistancePerLitter() {
        return FUEL_EFFICIENCY_VALUE;
    }

    @Override
    public int getDistance() {
        return this.distance;
    }

    @Override
    public String getName() {
        return CAR_NAME;
    }

    @Override
    public int getFuel() {
        return getDistance() / getDistancePerLitter();
    }
}
