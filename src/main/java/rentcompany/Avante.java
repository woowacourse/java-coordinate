package rentcompany;

public class Avante extends Car {
    private static final String NAME = "Avante";

    public Avante(int tripDistance) {
        super(tripDistance, 15);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
