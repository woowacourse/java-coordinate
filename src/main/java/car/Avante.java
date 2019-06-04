package car;

public class Avante extends Car {
    private static final double DPL = 15.0;

    public Avante(int tripDistance) {
        super(tripDistance);
    }

    double getDistancePerLiter() {
        return DPL;
    }
}