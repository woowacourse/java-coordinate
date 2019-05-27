package rentcompany;

public class Sonata extends Car {
    private static final String CAR_NAME = "Sonata";
    private static final double DISTANCE_PER_LITER = 10;

    private final int distance;

    public Sonata(int distance) {
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
