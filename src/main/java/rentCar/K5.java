package rentCar;

public class K5 extends Car {
    private static final int DISTANCE_PER_LITER = 13;
    private static final String NAME = "K5";

    public K5(int movingDistance) {
        super(movingDistance, NAME, DISTANCE_PER_LITER);
    }
}
