package fuel.domain;

class Sonata extends AbstractCar {
    private static final int FUEL_EFFICIENCY_VALUE = 10;
    private final int distance;


    Sonata(final int distance) {
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
        return "Sonata";
    }

}
