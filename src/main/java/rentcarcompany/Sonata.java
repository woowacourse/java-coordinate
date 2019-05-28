package rentcarcompany;

public class Sonata extends Car {
    private static final int DISTANCE_PER_LITER = 10;

    public Sonata(int distance) {
        super(distance, DISTANCE_PER_LITER);
    }

    @Override
    String getName() {
        return "Sonata";
    }
}
