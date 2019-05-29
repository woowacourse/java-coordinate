package calculator.domain;

import java.util.*;

/**
 * @author heebg
 * @version 1.0 2019-05-23
 */
public class Rectangle extends AbstractFigure {
    private static final String EX_NOT_RECTANGLE_MESSAGE = "x축, y축과 평행한 직사각형이 아닙니다.";
    private final Points points;
    private final List<Line> lines;

    public Rectangle(FigureType figureType) {
        super(figureType, FigureType.RECTANGLE);
        this.points = getPoints();
        this.lines = generateLines();
        checkFigureCondition();
    }

    private List<Line> generateLines() {
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(points.get(0), points.get(1)));
        lines.add(new Line(points.get(0), points.get(2)));
        lines.add(new Line(points.get(0), points.get(3)));
        Collections.sort(lines);
        lines.remove(2);
        return lines;
    }

    @Override
    void checkFigureCondition() {
        checkNotFigure(!(points.duplicateXCoordinateSize() == 2 && points.duplicateYCoordinateSize() == 2), EX_NOT_RECTANGLE_MESSAGE);
    }

    @Override
    public double perimeter() {
        double result = 0;
        for (Line line : lines) {
            result += line.perimeter();
        }
        return result * 2;
    }

    @Override
    public double area() {
        return lines.get(0).perimeter() * lines.get(1).perimeter();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(points, rectangle.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
