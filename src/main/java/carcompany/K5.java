package carcompany;

public class K5 extends Car {
    private static final double CAR_DISTANCE_PER_LITER = 13;

    public K5(final double tripDistance) {
        super(CAR_DISTANCE_PER_LITER, tripDistance);
    }

    @Override
    String getName() {
        return getClass().getSimpleName();
    }
}
