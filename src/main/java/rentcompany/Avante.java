package rentcompany;

public class Avante extends Car {
    private static final int EFFICIENCY = 15;
    private static final String NAME = "Avante";

    Avante(int distance) {
        super(EFFICIENCY, NAME, distance);
    }
}
