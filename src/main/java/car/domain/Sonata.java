package car.domain;

public class Sonata extends AbstractCar {
    private static final String NAME = "Sonata";
    private static final double FUEL_EFFICIENCY = 10;

    public Sonata(double distance) {
        super.distance = distance;
        super.fuelEfficiency = FUEL_EFFICIENCY;
    }

    @Override
    String getName() {
        return NAME;
    }

}
