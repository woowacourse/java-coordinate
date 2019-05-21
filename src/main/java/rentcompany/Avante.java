package rentcompany;

/**
 * @author heebg
 * @version 1.0 2019-05-21
 */
public class Avante extends Car {
    private final String NAME = "Avante";

    public static Avante create(double distance) {
        return new Avante(distance);
    }

    private Avante(double distance) {
        super(15, distance);
    }

    @Override
    String getName() {
        return NAME;
    }
}
