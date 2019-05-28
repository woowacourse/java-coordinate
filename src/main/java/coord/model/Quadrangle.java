package coord.model;

public class Quadrangle extends Figure {
    private static final String NAME = "사각형";

    protected Quadrangle(Points points) {
        super(points);
    }

    @Override
    public double area() {
        Point A = points.get(0);
        Point B = points.get(1);
        Point C = points.get(2);
        Point D = points.get(3);

        return areaOfTriangle(A, B, C) + areaOfTriangle(A, C, D);
    }

    @Override
    public String toString() {
        return NAME + " 넓이는 " + area();
    }
}