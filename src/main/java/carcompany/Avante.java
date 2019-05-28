package carcompany;

public class Avante extends Car {
    private static final double CAR_DISTANCE_PER_LITER = 15;

    public Avante(final double tripDistance) {
        super(CAR_DISTANCE_PER_LITER, tripDistance);
    }
}
