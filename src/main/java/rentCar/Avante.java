package rentCar;

public class Avante extends Car {
    private static final int DISTANCE_PER_LITER = 15;
    private static final String NAME = "Avante";

    public Avante(int movingDistance) {
        super(movingDistance, NAME, DISTANCE_PER_LITER);
    }
}
