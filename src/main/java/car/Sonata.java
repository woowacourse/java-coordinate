package car;

public class Sonata extends Car {
    private static final int DPL = 10;

    public Sonata(int tripDistance) {
        super(tripDistance);
    }

    @Override
    public int getDistancePerLiter() {
        return DPL;
    }
}