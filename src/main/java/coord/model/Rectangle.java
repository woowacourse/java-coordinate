package coord.model;

public class Rectangle extends Figure {
    protected Rectangle(Points points) {
        super(points);
    }

    @Override
    public double area() {
        points.sortByDescYAscX();
        Point A = points.get(0);
        Point B = points.get(1);
        Point C = points.get(2);
        Point D = points.get(3);
        if (A.x != C.x || B.x != D.x || A.y != B.y || C.y != D.y) {
            throw new IllegalArgumentException();
        }
        return (D.x - A.x) * (B.y - C.y);
    }
}