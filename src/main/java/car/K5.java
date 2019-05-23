package car;

public class K5 extends Car {
    private static final int DPL = 13;

    public K5(int tripDistance) {
        super(tripDistance);
    }

    @Override
    public int getDistancePerLiter() {
        return DPL;
    }
}