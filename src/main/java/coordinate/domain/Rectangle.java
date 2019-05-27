package coordinate.domain;

import java.util.Objects;

public class Rectangle {
    private Points points;

    public Rectangle(Points points) throws IllegalArgumentException{

        if (isNotRectangles(points)) {
            throw new IllegalArgumentException("사각형이 아닙니다.");
        }

        this.points = points;
    }

    public static Rectangle create(Points points) {

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

    private boolean isNotRectangles(Points points) {
        if (points.getSize() != 4) {
            throw new IllegalArgumentException("4개의 점이 입력되지 않았습니다.");
        }

        return !points.checkX() && points.checkY();
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
