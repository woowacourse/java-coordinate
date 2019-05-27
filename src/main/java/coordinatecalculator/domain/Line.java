package coordinatecalculator.domain;

import coordinatecalculator.domain.parent.Console;
import coordinatecalculator.domain.parent.Figure;

import java.util.List;

public class Line implements Figure, Console {
    private final Points points;

    Line(final Points points) {
        this.points = points;
    }

    @Override
    public double calculateResult() {
        List<Point> points = this.points.getSortedPoints();
        Point left = points.get(0);
        Point right = points.get(1);

        int x = Math.abs(right.getX() - left.getX());
        int y = Math.abs(right.getY() - left.getY());

        return Math.sqrt(x * x + y * y);
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
