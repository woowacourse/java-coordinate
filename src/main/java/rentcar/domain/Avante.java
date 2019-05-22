package rentcar.domain;

public class Avante extends Car {
    private static final String NAME = "Avante";
    private static final String LITTER = "리터";

    private static int distancePerLiter;

    private int tripDistance;

    public Avante(int tripDistance) {
        this.tripDistance = tripDistance;
        this.distancePerLiter = 15;
    }

    @Override
    double getTripDistance() {
        return tripDistance;
    }

    @Override
    String getName() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME +" : " + (int) getChargeQuantity() + LITTER;
    }
}
