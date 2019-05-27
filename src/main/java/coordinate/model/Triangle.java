package coordinate.model;

import coordinate.util.HeronFormula;

import java.util.List;

public class Triangle extends Figure {

    public Triangle(List<Point> points) {
        super(points);
        checkIsLine();
    }

    private void checkIsLine() {
        if (getIncline(0, 1) == getIncline(1, 2)) {
            throw new IllegalArgumentException("세 점이 한 직선에 있으면 안됩니다.");
        }
    }

    @Override
    public double getScore() {
        double a = getDistance(0, 1);
        double b = getDistance(0, 2);
        double c = getDistance(1, 2);
        return HeronFormula.getTriangleArea(a, b, c);
    }
}
