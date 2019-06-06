package rentcompany;

public class Avante extends Car {
    private static final String NAME = "Avante";
    private static final double DISTANCE_PER_LITER = 15;

    Avante(double tripDistance) {
        super(tripDistance);
    }

    @Override
    String getName() {
        return NAME;
    }

    @Override
    double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }

    @Override
    double getTripDistance() {
        return tripDistance;
    }
}