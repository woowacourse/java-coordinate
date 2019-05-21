package rentcarcompany;

public class K5 extends Car {
    private static final int DISTANCE_PER_LITER = 13;

    private final int distance;

    public K5(int distance) {
        this.distance = distance;
    }

    @Override
    double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }

    @Override
    double getTripDistance() {
        return distance;
    }

    @Override
    String getName() {
        return "K5";
    }
}
