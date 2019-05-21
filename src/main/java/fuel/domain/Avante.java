package fuel.domain;

public class Avante extends Car {
    private static final int FUEL_EFFICIENCY_VALUE = 15;
    private final int distance;

    public Avante(int distance) {
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
        return "Avante";
    }

}
