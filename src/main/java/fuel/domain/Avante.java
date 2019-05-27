package fuel.domain;

public class Avante extends AbstractCar implements Car  {
    private static final int FUEL_EFFICIENCY_VALUE = 15;
    private static final String CAR_NAME = "Avante";

    public Avante(final int distance) {
        super.distance = distance;
        super.fuelEfficiency = FUEL_EFFICIENCY_VALUE;
    }


    @Override
    public String getName() {
        return CAR_NAME;
    }


}
