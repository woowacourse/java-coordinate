package coord.model;

public class Rectangle extends Figure {
    private static final String NAME = "사각형";

    protected Rectangle(Points points) {
        super(points);
    }

    @Override
    public double area() {
        Point A = points.get(0);
        Point B = points.get(1);
        Point C = points.get(2);
        Point D = points.get(3);
        if (A.x != C.x || B.x != D.x || A.y != B.y || C.y != D.y) {
            throw new IllegalArgumentException("직사각형이 아닙니다.");
        }
        return (D.x - A.x) * (B.y - C.y);
    }

    @Override
    public String getName() {
        return NAME;
    }
}