package coordinate.domain;


import java.util.List;

public class Triangle extends AbstractFigure {

    Triangle(Points points) {
        super(points);
        checkTriangleValidation(points);
    }

    private void checkTriangleValidation(Points points) {
        if (checkTriangle(points)) {
            throw new IllegalArgumentException("삼각형의 좌표가 아닙니다.");
        }
    }

    private boolean checkTriangle(Points points) {
        List<Double> lines = LengthFactory.generateLengths(points);
        lines.sort(null);
        return lines.get(FIRST_POINT) + lines.get(SECOND_POINT) <= lines.get(THIRD_POINT);
    }

    @Override
    public double calculateArea() {
        List<Double> lines = LengthFactory.generateLengths(points);
        double a = lines.get(FIRST_POINT);
        double b = lines.get(SECOND_POINT);
        double c = lines.get(THIRD_POINT);
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public String getResult() {
        return "삼각형의 넓이는 %.2f 입니다.";
    }
}
