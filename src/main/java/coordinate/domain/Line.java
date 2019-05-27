package coordinate.domain;

public class Line implements Figure{
    private final Points points;

    private Line(Points points) {
        this.points = points;
    }

    public static Line from(Points points) {
        return new Line(points);
    }


    public double length() {
        Vector2 v = points.get(0).subtract(points.get(1));

        return Math.sqrt(v.doProduct(v));
    }

    @Override
    public Points getPoints() {
        return points;
    }
}
