package rentcar.car;

public class Avante implements Car {
    private static final int DISTANCE_PER_LITER = 15;
    private static final String CAR_NAME = "Avante";

    private int tripDistance;

    public Avante(int tripDistance) {
        this.tripDistance = tripDistance;
    }

    @Override
    public String getName() {
        return CAR_NAME;
    }

    @Override
    public double getChargeQuantity() {
        return tripDistance / DISTANCE_PER_LITER;
    }
}
