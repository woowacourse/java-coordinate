package coordinate.domain;

import java.util.List;

public class Rectangle extends AbstractFigure {

    Rectangle(Points points) {
        super(points);
        checkRectangleValidation(points);
    }

    private void checkRectangleValidation(Points points) {
        List<Double> lines = LengthFactory.generateLengths(points);
        lines.sort(null);
        for (int i = 0; i < lines.size(); i += 2) {
            checkTriangle(lines, i);
        }
    }

    private void checkTriangle(List<Double> lines, int index) {
        if (!(lines.get(index).equals(lines.get(index + 1)))) {
            throw new IllegalArgumentException("직사각형이나 정사각형이 아닙니다.");
        }
    }

    @Override
    public double calculateArea() {
        double width = points.getPoint(FIRST_POINT).calculateLength(points.getPoint(SECOND_POINT));
        double depth = points.getPoint(FIRST_POINT).calculateLength(points.getPoint(THIRD_POINT));
        return width * depth;
    }

    public String getResult() {
        return "사각형의 넓이는 %.2f 입니다.";
    }
}
