package rentcompany;

public class Avante extends Car {

    private static final String CAR_NAME = "Avante";
    private static final double DISTANCE_PER_LITER = 15;

    private final int distance;

    public Avante(int distance) {
        this.distance = validDistance(distance);
    }

    @Override
    double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }

    @Override
    double getTripDistance() {
        return this.distance;
    }

    @Override
    String getName() {
        return CAR_NAME;
    }
}
