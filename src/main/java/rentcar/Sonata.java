package rentcar;

public class Sonata extends CarAbstract {
    private final static int DISTANCE_PER_LITER = 10;
    private final static String CAR_NAME = "Sonata";

    public Sonata(int distance) {
        super(CAR_NAME, distance, DISTANCE_PER_LITER);
    }
}
