package coord.model;

public class Line {
    private final Points points;

    protected Line(Points points) {
        this.points = points;
    }

    public double length() {
        Point A = points.get(0);
        Point B = points.get(1);
        return Math.sqrt(Math.pow((A.x - B.x), 2.0) + Math.pow((A.y - B.y), 2.0));
    }
}