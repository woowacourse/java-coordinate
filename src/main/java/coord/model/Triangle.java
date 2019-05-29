package coord.model;


import coord.view.ConsoleMessages;

public class Triangle extends Figure {
    private static final String NAME = "삼각형";

    protected Triangle(Points points) {
        super(points);
        validate(points);
    }

    private void validate(Points points) {
        Point A = points.get(0);
        Point B = points.get(1);
        Point C = points.get(2);

        if ((A.y - B.y) / (A.x - B.x) == (B.y - C.y) / (B.x - C.x)) {
            throw new IllegalArgumentException(ConsoleMessages.ERR_FIGURE.message());
        }

    }

    @Override
    public double area() {
        return areaOfTriangle(points);
    }

    @Override
    public String toString() {
        return NAME + " 넓이는 " + area();
    }
}