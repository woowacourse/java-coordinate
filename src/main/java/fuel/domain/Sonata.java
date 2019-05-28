package fuel.domain;

public class Sonata extends AbstractCar {
    private static final int FUEL_EFFICIENCY_VALUE = 10;
    private static final String CAR_NAME = "Sonata";

    public Sonata(final int distance) {
        super.distance = distance;
        super.fuelEfficiency = FUEL_EFFICIENCY_VALUE;
    }

    @Override
    public String getName() {
        return CAR_NAME;
    }


}
