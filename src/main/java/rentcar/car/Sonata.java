package rentcar.car;

public class Sonata implements Car {
    private static final int DISTANCE_PER_LITER = 10;
    private static final String CAR_NAME = "Sonata";

    private int tripDistance;

    public Sonata(int tripDistance) {
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
