package rentcompany;

public class Sonata extends Car {
    private final static int EFFICIENCY = 10;
    private static final String NAME = "Sonata";

    Sonata(final int distance) {
        super(EFFICIENCY, NAME, distance);
    }
}
