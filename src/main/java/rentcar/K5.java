package rentcar;

public class K5 extends CommonCar {
    private final static int DISTANCE_PER_LITER = 13;
    private final static String CAR_NAME = "K5";

    public K5(int distance) {
        super(CAR_NAME, distance, DISTANCE_PER_LITER);
    }
}
