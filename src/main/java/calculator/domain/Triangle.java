package calculator.domain;

import java.util.*;

/**
 * @author heebg
 * @version 1.0 2019-05-23
 */
public class Triangle extends AbstractFigure {
    private static final String EX_NOT_TRIANGLE_MESSAGE = "삼각형이 될 수 없는 조건입니다.";
    private final Points points;
    private final List<Line> lines;

    public Triangle(FigureType figureType) {
        super(figureType, FigureType.TRIANGLE);
        this.points = getPoints();
        this.lines = generateLines();
        checkFigureCondition();
    }

    private List<Line> generateLines() {
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(points.get(0), points.get(1)));
        lines.add(new Line(points.get(1), points.get(2)));
        lines.add(new Line(points.get(0), points.get(2)));
        Collections.sort(lines);
        return lines;
    }

    @Override
    void checkFigureCondition() {
        double TRI_LONGEST_SIDE = lines.get(2).perimeter();
        double TRI_OTHER_SIDE = lines.get(1).perimeter();
        double TRI_ANOTHER_SIDE = lines.get(0).perimeter();

        checkNotFigure(TRI_LONGEST_SIDE >= TRI_OTHER_SIDE + TRI_ANOTHER_SIDE, EX_NOT_TRIANGLE_MESSAGE);
    }

    @Override
    public double perimeter() {
        double result = 0;
        for (Line line : lines) {
            result += line.perimeter();
        }
        return result;
    }

    @Override
    public double area() {
        double powerLongestSide = Math.pow(lines.get(2).perimeter(), 2);
        double powerOtherSide = Math.pow(lines.get(0).perimeter(), 2);
        double powerAnotherSide = Math.pow(lines.get(1).perimeter(), 2);
        return Math.sqrt(4 * powerOtherSide * powerAnotherSide - Math.pow(powerOtherSide + powerAnotherSide - powerLongestSide, 2)) / 4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(points, triangle.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}