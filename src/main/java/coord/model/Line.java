package coord.model;

public class Line extends Figure {
    protected Line(Points points) {
        super(points);
    }

    @Override
    public double area() {
        return .0;
    }

    public double length() {
        Point A = points.get(0);
        Point B = points.get(1);
        return Math.sqrt(Math.pow((A.x - B.x), 2.0) + Math.pow((A.y - B.y), 2.0));
    }
}