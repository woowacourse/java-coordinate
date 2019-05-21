package rentcarcompany;

public class Avante extends Car {
    private static final int DISTANCE_PER_LITER = 15;

    public Avante(int distance) {
        super(distance, DISTANCE_PER_LITER);
    }

    @Override
    String getName() {
        return "Avante";
    }
}
