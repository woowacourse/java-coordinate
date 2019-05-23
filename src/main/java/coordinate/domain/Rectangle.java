package coordinate.domain;

import java.util.*;

public class Rectangle {
    private static final int POINT_COUNT = 4;

    private final PointGroup points;

    public Rectangle(PointGroup points) {
        validatePoints(points);
        this.points = points;
    }

    private void validatePoints(PointGroup points) {
        if (points.size() != POINT_COUNT) {
            throw new IllegalArgumentException("직사각형은 4개의 점으로 이루어져야합니다.");
        }
        if (!checkRectangle(points.getDistances())) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
    }

    private boolean checkRectangle(List<Double> distances) {
        System.out.println(distances);
        if (distances.size() == 2
                && checkPythagorean(distances.get(1), distances.get(0), distances.get(0))) {
            return true;
        }
        if (distances.size() == 3
                && checkPythagorean(distances.get(2), distances.get(1), distances.get(0))) {
            return true;
        }
        return false;
    }

    private boolean checkPythagorean(double hypotenuseSquare, double side1, double side2) {
        return Double.compare(hypotenuseSquare, side1 + side2) == 0;
    }

    public double area() {
        List<Double> lengths = points.getDistances();
        if (lengths.size() == 2) {
            return lengths.get(0);
        }
        return Math.sqrt(lengths.get(0) * lengths.get(1));
    }

}
