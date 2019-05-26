package coordinate.domain;

public class Rectangle {
    private final Points points;

    private Rectangle(Points points) {
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
}
