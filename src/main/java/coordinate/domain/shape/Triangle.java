package coordinate.domain.shape;

import coordinate.domain.point.Point;

import java.util.List;

public class Triangle extends AbstractShape {
    private static final int HERON_FORMULA_NUMBER = 2;

    public Triangle(List<Point> points) {
        super(points);
        validateShape();
    }

    @Override
    public void validateShape() {
        double longestLine = max();
        double sumWithoutLongestLine = sum() - longestLine;

        if (longestLine >= sumWithoutLongestLine) {
            throw new IllegalArgumentException("올바른 삼각형을 입력해 주세요.");
        }
    }

    @Override
    public double area() {
        double heron = sum() / HERON_FORMULA_NUMBER;
        double area = heron;

        for (Double triangleLine : getLines()) {
            area *= (heron - triangleLine);
        }
        return Math.sqrt(area);
    }

    

    @Override
    public String toString() {
        return "삼각형 넓이는 " + area();
    }
}
