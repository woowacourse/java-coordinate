package rentcarcompany;

public class Avante extends Car {
    private static final int DISTANCE_PER_LITER = 15;

    private final int distance;

    public Avante(int distance) {
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
        return "Avante";
    }
}
