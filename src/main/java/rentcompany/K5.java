package rentcompany;

public class K5 extends Car {
    private static final String NAME = "K5";

    public K5(int tripDistance) {
        super(tripDistance, 13);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
