package location.domain;

public class Rectangle extends Shape {

    private static final String NOT_RECTANGLE_MSG = "직사각형이 아닙니다.";

    private final Point point1;
    private final Point point2;
    private final Point point3;
    private final Point point4;

    public Rectangle(Point point1, Point point2, Point point3, Point point4) {
        isValid(point1, point2, point3, point4);
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
    }

    private void isValid(Point point1, Point point2, Point point3, Point point4) {
        isRectangle(point1, point2, point3, point4);
    }

    private void isRectangle(Point point1, Point point2, Point point3, Point point4) {
        if (isSameDiagonal(point1, point2, point3, point4)
                && isSameCenterX(point1, point2, point3, point4)
                && isSameCenterY(point1, point2, point3, point4)) {
            return;
        }
        throw new IllegalArgumentException(NOT_RECTANGLE_MSG);
    }

    private boolean isSameCenterX(Point point1, Point point2, Point point3, Point point4) {
        return ((point2.getX() + point3.getX()) / 2) == ((point1.getX() + point4.getX()) / 2);
    }

    private boolean isSameCenterY(Point point1, Point point2, Point point3, Point point4) {
        return ((point2.getY() + point3.getY()) / 2) == ((point1.getY() + point4.getY()) / 2);
    }

    private boolean isSameDiagonal(Point point1, Point point2, Point point3, Point point4) {
        return calculateLine(point2, point3) == calculateLine(point1, point4);
    }

    public double calculateLine(Point point1, Point point2) {
        return Math.sqrt(Math.pow((point1.getX() - point2.getX()), 2) + Math.pow((point1.getY() - point2.getY()), 2));
    }

    public double calculateArea() {
        return calculateLine(point1, point2) * calculateLine(point1, point3);
    }
}
