package coordinate.domain;

import java.util.Objects;

public class Triangle extends Figure {
    private final Points points;

    public Triangle(Points points) {
        super("삼각형의 넓이는 : ");
        this.points = points;
        checkValidCoordinate();
    }

    private void checkValidCoordinate() {
        if (calculateResult() == 0) {
            throw new IllegalArgumentException("삼각형을 만들 수 없습니다.");
        }
    }

    @Override
    public double calculateResult() {
        double a = points.getPoints(0).calculateDistance(points.getPoints(1));
        double b = points.getPoints(0).calculateDistance(points.getPoints(2));
        double c = points.getPoints(1).calculateDistance(points.getPoints(2));
        double s = (a + b + c) / 2;
        return Math.round((Math.sqrt(s * (s - a) * (s - b) * (s - c)) * 1000)) / 1000;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(points, triangle.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
