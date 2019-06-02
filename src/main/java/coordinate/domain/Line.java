package coordinate.domain;

public class Line extends Figure {
    public static final int NUMBER_OF_POINTS = 2;

    public Line(Points points) {
        super(points);
    }

    @Override
    protected void validate() {
        validateSize();
    }

    protected void validateSize() {
        super.validateSize(NUMBER_OF_POINTS);
    }

    @Override
    public double length() {
        Point a = getPoint(0);
        Point b = getPoint(1);
        return a.length(b);
    }
}
