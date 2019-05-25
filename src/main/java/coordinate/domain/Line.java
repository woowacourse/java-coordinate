package coordinate.domain;

public class Line extends AbstractFigure {
    public static final int NUMBER_OF_POINTS = 2;

    public Line(Points points) {
        super(points);
    }

    @Override
    public int size() {
        return NUMBER_OF_POINTS;
    }

    @Override
    public double area() {
        Point a = getPoints().get(0);
        Point b = getPoints().get(1);
        return a.length(b);
    }

    @Override
    public String getName() {
        return "선 ";
    }
}
