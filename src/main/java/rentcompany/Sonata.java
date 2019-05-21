package rentcompany;

/**
 * @author heebg
 * @version 1.0 2019-05-21
 */
public class Sonata extends Car {
    private final String NAME = "Sonata";

    public static Sonata create(double distance) {
        return new Sonata(distance);
    }

    private Sonata(double distance) {
        super(10, distance);
    }

    @Override
    String getName() {
        return NAME;
    }
}
