package coordinate.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Rectangle extends AbstractFigure {
    private Rectangle(Points points) {
        super(points);
        validateRectangle(this.points);
    }

    private void validateRectangle(Points points) {
        List<Integer> xValues = points.toList().stream().mapToInt(point -> point.getX().toInt()).boxed().collect(Collectors.toList());
        if (!has2Values2Cnt(xValues)) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }

        List<Integer> yValues = points.toList().stream().mapToInt(point -> point.getY().toInt()).boxed().collect(Collectors.toList());
        if (!has2Values2Cnt(yValues)) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
    }

    private boolean has2Values2Cnt(List<Integer> numbers) {
        return !isAllEqual(numbers) && numbers.stream().reduce(0, (a, b) -> a ^ b).intValue() == 0;
    }

    private boolean isAllEqual(List<Integer> numbers) {
        int firstNumber = numbers.get(0);
        long firstEqualCount = numbers.stream().filter(number -> firstNumber == number).count();

        return firstEqualCount == numbers.size();
    }

    public static Rectangle from(Points points) {
        return new Rectangle(points);
    }

    public double area() {
        Point p = points.get(0);

        Point pNextX = points.find(point -> !point.equals(p) && point.hasEqualX(p));
        Point pNextY = points.find(point -> !point.equals(p) && point.hasEqualY(p));

        double w = p.distance(pNextX);
        double h = p.distance(pNextY);

        return w * h;
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
