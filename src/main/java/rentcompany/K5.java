package rentcompany;

/**
 * @author heebg
 * @version 1.0 2019-05-21
 */
public class K5 extends Car {
    private final String NAME = "K5";

    public static K5 create(double distance) {
        return new K5(distance);
    }

    private K5(double distance) {
        super(13, distance);
    }

    @Override
    String getName() {
        return NAME;
    }
}
