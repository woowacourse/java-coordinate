package coord.model;


public class Triangle extends Figure {
    private static final String NAME = "삼각형";

    protected Triangle(Points points) {
        super(points);
    }

    @Override
    public double area() {
        return areaOfTriangle(points);
     }

    @Override
    public String getName() {
        return NAME;
    }
}