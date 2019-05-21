package car;

public class Sonata extends Car {
    private static final double DPL = 10.0;

    public Sonata(int tripDistance) {
        super(tripDistance);
    }

    double getDistancePerLiter() {
        return DPL;
    }
}