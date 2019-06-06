package rentcompany;

public class Sonata extends Car {
    private static final String NAME = "Sonata";

    public Sonata(int tripDistance) {
        super(tripDistance, 10);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
