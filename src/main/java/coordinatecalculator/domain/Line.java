package coordinatecalculator.domain;

import coordinatecalculator.domain.parent.AbstractFigure;

import java.util.List;

public class Line extends AbstractFigure {
    private static final String NAME = "선";
    private static final String RESULT_TYPE = "길이";

    private Line(final Points points) {
        super(points);
    }

    public static Line newInstance(final Points points) {
        return new Line(points);
    }

    @Override
    public double calculateResult() {
        List<Point> points = this.points.getSortedPoints();
        Point p1 = points.get(0);
        Point p2 = points.get(1);

        int dx = p1.differenceByX(p2);
        int dy = p1.differenceByY(p2);

        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getResultType() {
        return RESULT_TYPE;
    }
}
