package coordinate.domain;

public class Line extends AbstractFigure {
    private Line(Points points) {
        super(points);
    }

    public static Line from(Points points) {
        return new Line(points);
    }

    public double length() {
        Vector2 v = points.get(0).subtract(points.get(1));

        return Math.sqrt(v.doProduct(v));
    }

    @Override
    String getFigureName() {
        return "선";
    }

    @Override
    String getMeasureUnitName() {
        return "길이";
    }

    @Override
    double measure() {
        return length();
    }
}
