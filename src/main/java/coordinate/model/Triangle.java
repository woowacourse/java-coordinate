package coordinate.model;

import coordinate.util.HeronFormula;

import java.util.Collections;
import java.util.List;

public class Triangle extends Figure {

    public Triangle(List<Point> points) {
        super(points);
        checkIsLine(points);
    }

    private void checkIsLine(List<Point> points) {
        Collections.sort(points);
        if (points.get(0).getIncline(points.get(1))
                == points.get(1).getIncline(points.get(2))) {
            throw new IllegalArgumentException("세 점이 한 직선에 있으면 안됩니다.");
        }
    }

    @Override
    public double getScore() {
        double a = points.get(0).getDistance(points.get(1));
        double b = points.get(0).getDistance(points.get(2));
        double c = points.get(1).getDistance(points.get(2));
        return HeronFormula.getTriangleArea(a, b, c);
    }
}
