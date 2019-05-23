package coordinate.domain.Figure;

import coordinate.domain.point.PointGroup;

import java.util.*;

public class Rectangle extends Figure implements AreaCalculable {
    private static final int POINT_COUNT = 4;

    public Rectangle(PointGroup points) {
        super(points, POINT_COUNT);
    }

    @Override
    public double area() {
        List<Double> lengths = new ArrayList<>(getPoints().getSquaredDistances());
        Collections.sort(lengths);
        if (lengths.size() == 2) {
            return lengths.get(0);
        }
        return Math.sqrt(lengths.get(0) * lengths.get(1));
    }

    @Override
    void validatePoints(PointGroup points) {
        if (points.size() != POINT_COUNT) {
            throw new IllegalArgumentException("직사각형은 4개의 점으로 이루어져야합니다.");
        }
        if (!checkRectangle(points.getSquaredDistances())) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
    }

    private boolean checkRectangle(Set<Double> lengths) {
        List<Double> distances = new ArrayList<>(lengths);
        Collections.sort(distances);
        if (distances.size() == 2
                && checkPythagorean(distances.get(1), distances.get(0), distances.get(0))) {
            return true;
        }
        return distances.size() == 3
                && checkPythagorean(distances.get(2), distances.get(1), distances.get(0));
    }

    private boolean checkPythagorean(double hypotenuseSquare, double side1, double side2) {
        return Double.compare(hypotenuseSquare, side1 + side2) == 0;
    }

    @Override
    public String toString() {
        return "사각형";
    }
}
