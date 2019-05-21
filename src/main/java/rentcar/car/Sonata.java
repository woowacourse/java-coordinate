package rentcar.car;

public class Sonata extends Car {
    private static final int DISTANCE_PER_LITER = 10;
    private static final String NAME = "Sonata";

    public Sonata(int movingDistance) {
        super(movingDistance, NAME, DISTANCE_PER_LITER);
    }
}
