package car.domain;

public class Avante extends AbstractCar {
    private static final String NAME = "Avante";
    private static final double FUEL_EFFICIENCY = 15;

    public Avante(double distance) {
        super.distance = distance;
        super.fuelEfficiency = FUEL_EFFICIENCY;
    }

    @Override
    String getName() {
        return NAME;
    }
}
