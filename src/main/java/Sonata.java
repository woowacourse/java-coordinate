public class Sonata extends Car {
    private static final int FUEL_EFFICIENCY = 10;

    public Sonata(int distance) {
        super(distance);
    }

    @Override
    public int getDistancePerLiter() {
        return FUEL_EFFICIENCY;
    }
}
