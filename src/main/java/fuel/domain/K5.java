package fuel.domain;

class K5 extends AbstractCar {
    private static final int FUEL_EFFICIENCY_VALUE = 13;
    private final int distance;

    K5(int distance) {
        this.distance = distance;
    }

    @Override
    int getDistancePerLitter() {
        return FUEL_EFFICIENCY_VALUE;
    }

    @Override
    int getDistance() {
        return this.distance;
    }

    @Override
    String getName() {
        return "K5";
    }
}
