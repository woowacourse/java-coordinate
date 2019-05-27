package coordinate.domain;

public class Rectangle extends AbstractFigure{
    private final Points points;

    private Rectangle(Points points) {
        super(points);
        this.points = points;
    }

    public static Rectangle from(Points points) {
        return new Rectangle(points);
    }

    public double area() {
        Point p = points.get(0);

        Point pNextX = points.find(point -> !point.equals(p) && point.getX() == p.getX());
        Point pNextY = points.find(point -> !point.equals(p) && point.getY() == p.getY());

        double w = p.subtract(pNextX).length();
        double h = p.subtract(pNextY).length();

        return w * h;
    }

    @Override
    public Points getPoints() {
        return points;
    }

    @Override
    String getFigureName() {
        return "사각형";
    }

    @Override
    String getMeasureUnitName() {
        return "넓이";
    }

    @Override
    double measure() {
        return area();
    }
}
