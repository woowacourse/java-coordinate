package carcompany;

public class Sonata extends Car {
    private static final double CAR_DISTANCE_PER_LITER = 10;

    public Sonata(int tripDistance) {
        super(CAR_DISTANCE_PER_LITER, tripDistance);
    }

    @Override
    String getName() {
        return getClass().getSimpleName();
    }
}
