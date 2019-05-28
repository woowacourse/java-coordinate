package rentcarcompany;

public class K5 extends Car {
    private static final int DISTANCE_PER_LITER = 13;

    public K5(int distance) {
        super(distance, DISTANCE_PER_LITER);
    }

    @Override
    String getName() {
        return "K5";
    }
}
