package car;

public class K5 extends Car {
    private final static int FUEL_EFFICIENCY = 13;

    public K5(int distance) {
        super(distance);
    }

    @Override
    public int getDistancePerLiter() {
        return FUEL_EFFICIENCY;
    }
}
