package coordinate.domain;

import java.util.Objects;

public class Rectangle {
    private Points points;

    public Rectangle(Points points) {
        this.points = points;
    }

    public static Rectangle create(Point point1, Point point2, Point point3, Point point4) {
        Points points = Points.create();

        points.addPoint(point1);
        points.addPoint(point2);
        points.addPoint(point3);
        points.addPoint(point4);

        return new Rectangle(points);
    }

    public double getArea() {
        double height = points.getFirstDistance();
        double weight = points.getSecondDistance();

        return height * weight;
    }

    public Points getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(points, rectangle.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
