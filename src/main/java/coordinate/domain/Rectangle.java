package coordinate.domain;

import java.util.Objects;

public class Rectangle extends Figure {
    private static final int NON_DUPLICATE_COORDINATE_SIZE = 2;
    private static final int FIRST_POINT = 0;
    private static final int SECOND_POINT = 1;
    private static final int THIRD_POINT = 2;

    public Rectangle(Points points) {
        super("사각형의 넓이는 : ", points);
        checkValidCoordinate(points.getNonDuplicateXSize());
        checkValidCoordinate(points.getNonDuplicateYSize());
    }

    private void checkValidCoordinate(int size) {
        if (size != NON_DUPLICATE_COORDINATE_SIZE) {
            throw new IllegalArgumentException("직사각형만 가능합니다.");
        }
    }

    @Override
    public double calculateResult() {
        double height = points.getPoint(FIRST_POINT).calculateDistance(points.getPoint(SECOND_POINT));
        double width = points.getPoint(FIRST_POINT).calculateDistance(points.getPoint(THIRD_POINT));
        return height * width;
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
