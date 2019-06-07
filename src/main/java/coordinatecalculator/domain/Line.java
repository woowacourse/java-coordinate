package coordinatecalculator.domain;

import coordinatecalculator.domain.parent.Figure;

import java.util.List;

public class Line implements Figure {
    private static final String LINE_RESULT_MESSAGE = "두 점 사이 거리는 ";
    private final Points points;

    private Line(final Points points) {
        this.points = points;
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
    public String makeResult() {
        return LINE_RESULT_MESSAGE + calculateResult();
    }

    @Override
    public Points getPoints() {
        return this.points;
    }
}
