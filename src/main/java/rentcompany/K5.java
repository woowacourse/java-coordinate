package rentcompany;

public class K5 extends Car {

    private static final String CAR_NAME = "K5";
    private static final double DISTANCE_PER_LITER = 13;

    private final int distance;

    public K5(int distance) {
        this.distance = validDistance(distance);
    }

    @Override
    public double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }

    @Override
    public double getTripDistance() {
        return this.distance;
    }

    @Override
    public String getName() {
        return CAR_NAME;
    }
}
