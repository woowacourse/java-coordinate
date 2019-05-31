package coordinate.domain;

import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Rectangle extends AbstractFigure {
    private Rectangle(Points points) {
        super(points);
        validateRectangle(points);
    }

    private void validateRectangle(Points points) {
        List<Integer> xValues = pointsToIntList(points, Point::getXInt);
        if (!has2Values2Cnt(xValues)) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }

        List<Integer> yValues = pointsToIntList(points, Point::getYInt);
        if (!has2Values2Cnt(yValues)) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
    }

    private List<Integer> pointsToIntList(Points points, ToIntFunction<Point> mapper) {
        return points.toList().stream()
                .mapToInt(mapper)
                .boxed()
                .collect(Collectors.toList());
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
        Point p = getPoints().get(0);

        Point pNextX = getPoints().find(point -> !point.equals(p) && point.hasEqualX(p));
        Point pNextY = getPoints().find(point -> !point.equals(p) && point.hasEqualY(p));

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
