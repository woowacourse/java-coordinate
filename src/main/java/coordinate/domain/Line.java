package coordinate.domain;

public class Line {
    private final Points points;

    public Line(Points points) {
        this.points = points;
    }

    public double length() {
        Vector2 v = points.get(0).subtract(points.get(1));

        return Math.sqrt(v.doProduct(v));
    }
}
