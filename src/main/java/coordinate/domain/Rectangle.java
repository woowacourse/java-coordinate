package coordinate.domain;

import java.util.List;

public class Rectangle extends AbstractFigure {
    static final int COUNT_OF_POINT = 4;

    Rectangle(Points points) {
        super(points);
        checkRectangleValidation(points);
    }

    private void checkRectangleValidation(Points points) {
        List<Double> lines = LengthFactory.generateLengths(points);
        lines.sort(null);
        for (int i = 0; i < lines.size(); i += 2) {
            checkRectangle(lines, i);
        }
    }

    private void checkRectangle(List<Double> lines, int index) {
        if (!(lines.get(index).equals(lines.get(index + 1)))) {
            throw new IllegalArgumentException("직사각형이나 정사각형이 아닙니다.");
        }
    }

    @Override
    public double calculateArea() {
        double width = getPoint(FIRST_POINT).calculateLength(getPoint(SECOND_POINT));
        double depth = getPoint(FIRST_POINT).calculateLength(getPoint(THIRD_POINT));
        return width * depth;
    }
    @Override
    public String getResult() {
        return "사각형의 넓이는 %.2f 입니다.";
    }
}
