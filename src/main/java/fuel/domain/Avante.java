package fuel.domain;

class Avante extends AbstractCar {
    private static final int FUEL_EFFICIENCY_VALUE = 15;
    private final int distance;

    Avante(int distance) {
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
        return "Avante";
    }

}
