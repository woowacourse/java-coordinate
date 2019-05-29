package coordinate.domain;

public class DefaultPoint extends Point {
    public DefaultPoint(int x, int y) {
        super(x, y);
    }

    @Override
    void validate(int x, int y) {
        // do nothing
    }
}
