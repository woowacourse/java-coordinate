package rentcar.car;

public class K5 implements Car{
    private static final int DISTANCE_PER_LITER = 13;
    private static final String CAR_NAME = "K5";

    private int tripDistance;

    public K5(int tripDistance) {
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
