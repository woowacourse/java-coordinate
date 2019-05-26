package coordinate.model;

import coordinate.util.HeronFormula;

import java.util.List;

public class Triangle extends Figure {

    public Triangle(List<Point> points) {
        super(points);
        checkIsLine(points);
    }

    private void checkIsLine(List<Point> points) {
        if (points.get(0).getIncline(points.get(1))
                == points.get(1).getIncline(points.get(2))) {
            throw new IllegalArgumentException("세 점이 한 직선에 있으면 안됩니다.");
        }
    }

    @Override
    public double getScore() {
        double a = super.getPoint(0).getDistance(super.getPoint(1));
        double b = super.getPoint(0).getDistance(super.getPoint(2));
        double c = super.getPoint(1).getDistance(super.getPoint(2));
        return HeronFormula.getTriangleArea(a, b, c);
    }
}
