package coordinate;

import java.util.List;
import java.util.Objects;

public class Triangle {
    private List<Point> points;

    public Triangle(List<Point> points) {
        validateTriangle(points);
        this.points = points;
    }

    private void validateTriangle(List<Point> points) {
        if (points.get(0).getSlope(points.get(1)) == points.get(0).getSlope(points.get(2))) {
            throw new IllegalArgumentException();
        }
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
