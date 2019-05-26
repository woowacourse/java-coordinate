package coordinate.domain;


import java.util.List;

public class Triangle extends AbstractFigure {

    Triangle(Points points) {
        super(points);
        checkTriangleValidation(points);
    }

    private void checkTriangleValidation(Points points){
        if (checkTriangle(points)) {
            throw new IllegalArgumentException("삼각형의 좌표가 아닙니다.");
        }
    }

    private boolean checkTriangle(Points points) {
        List<Double> lines = LengthFactory.generateLengths(points);
        lines.sort(null);
        return lines.get(0) + lines.get(1) <= lines.get(2);
    }

    @Override
    public double calculateArea() {
        List<Double> lines = LengthFactory.generateLengths(points);
        double a = lines.get(0);
        double b = lines.get(1);
        double c = lines.get(2);
        double s = (lines.get(0) + lines.get(1) + lines.get(2)) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public String getResult() {
        return "삼각형의 넓이는 %.2f 입니다.";
    }
}
