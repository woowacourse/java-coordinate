package coordinatecalculator.domain;

import coordinatecalculator.domain.parent.Figure;

import java.util.List;

public class Line implements Figure {
    public static final String LINE_RESULT_MESSAGE = "두 점 사이 거리는 ";
    private final Points points;

    public Line(final Points points) {
        this.points = points;
    }

    @Override
    public double calculateResult() {
        List<Point> points = this.points.getSortedPoints();
        Point p1 = points.get(0);
        Point p2 = points.get(1);

        int x = Math.abs(p2.getX() - p1.getX());
        int y = Math.abs(p2.getY() - p1.getY());

        return Math.sqrt(x * x + y * y);
    }

    @Override
    public String makeResult() {
        StringBuilder sb = new StringBuilder(LINE_RESULT_MESSAGE);
        return sb.append(calculateResult()).toString();
    }

    @Override
    public Points getPoints() {
        return this.points;
    }
}
