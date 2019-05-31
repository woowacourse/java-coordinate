package coordinate.domain;

public class DefaultPoint extends AbstractPoint {
    public DefaultPoint(CoordinateNumber x, CoordinateNumber y) {
        super(x, y);
    }

    public static DefaultPoint ofInts(int x, int y) {
        return new DefaultPoint(CoordinateNumber.valueOf(x), CoordinateNumber.valueOf(y));
    }

    @Override
    void validate(int x, int y) {
        // do nothing
    }
}
