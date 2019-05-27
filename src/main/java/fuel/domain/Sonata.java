package fuel.domain;

public class Sonata implements Car {
    private static final int FUEL_EFFICIENCY_VALUE = 10;
    private static final String CAR_NAME = "Sonata";
    private final int distance;

    public Sonata(final int distance) {
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
