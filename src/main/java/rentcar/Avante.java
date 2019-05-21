package rentcar;

public class Avante extends CarAbstract {
    private final static int DISTANCE_PER_LITER = 15;
    private final static String CAR_NAME = "Avante";

    public Avante(int distance) {
        super(CAR_NAME, distance, DISTANCE_PER_LITER);
    }
}
