package coordinate.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Rectangle extends AbstractFigure{
    private final Points points;

    private Rectangle(Points points) {
        super(points);
        validateRectangle(points);
        this.points = points;
    }

    private void validateRectangle(Points points) {
        List<Integer> xValues = points.toList().stream().mapToInt(point -> point.getX()).boxed().collect(Collectors.toList());
        if (!has2Values2Cnt(xValues)) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }

        List<Integer> yValues = points.toList().stream().mapToInt(point -> point.getY()).boxed().collect(Collectors.toList());
        if (!has2Values2Cnt(yValues)) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
    }

    private boolean has2Values2Cnt(List<Integer> numbers) {
        return !isAllEqual(numbers) && numbers.stream().reduce(0, (a, b) -> a ^ b).intValue() == 0;
    }

    private boolean isAllEqual(List<Integer> numbers) {
        int firstNumber = numbers.get(0);
        return numbers.stream().filter(number -> firstNumber == number).count() == numbers.size();
    }

    public static Rectangle from(Points points) {
        return new Rectangle(points);
    }

    public double area() {
        Point p = points.get(0);

        Point pNextX = points.find(point -> !point.equals(p) && point.getX() == p.getX());
        Point pNextY = points.find(point -> !point.equals(p) && point.getY() == p.getY());

        double w = p.subtract(pNextX).length();
        double h = p.subtract(pNextY).length();

        return w * h;
    }

    @Override
    public Points getPoints() {
        return points;
    }

    @Override
    String getFigureName() {
        return "사각형";
    }

    @Override
    String getMeasureUnitName() {
        return "넓이";
    }

    @Override
    double measure() {
        return area();
    }
}
