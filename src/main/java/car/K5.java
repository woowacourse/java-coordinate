package car;

public class K5 extends Car {
    private static final double DPL = 13.0;

    public K5(int tripDistance) {
        super(tripDistance);
    }

    double getDistancePerLiter() {
        return DPL;
    }
}