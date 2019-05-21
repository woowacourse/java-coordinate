public class Avante extends Car {
    private static final int FUEL_EFFICIENCY = 15;

    public Avante(int distance) {
        super(distance);
    }

    @Override
    public int getDistancePerLiter() {
        return FUEL_EFFICIENCY;
    }
}
