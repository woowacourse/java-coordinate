package car;

public class Avante extends Car {
    private static final int DPL = 15;

    public Avante(int tripDistance) {
        super(tripDistance);
    }

    @Override
    public int getDistancePerLiter() {
        return DPL;
    }
}