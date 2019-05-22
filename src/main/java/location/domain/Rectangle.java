package location.domain;

public class Rectangle extends Shape {
    private static final String NOT_RECTANGLE_MSG = "직사각형이 아닙니다.";
    private static final int SQUARE = 2;
    private final Point point1;
    private final Point point2;
    private final Point point3;
    private final Point point4;

    public Rectangle(final Points points) {
        isValid(points);
        this.point1 = points.get(0);
        this.point2 = points.get(1);
        this.point3 = points.get(2);
        this.point4 = points.get(3);
    }

    private void isValid(final Points points) {
        isRectangle(points);
    }

    private void isRectangle(final Points points) {
        if (isSameDiagonal(points)
                && isSameCenterX(points)
                && isSameCenterY(points)) {
            return;
        }
        throw new IllegalArgumentException(NOT_RECTANGLE_MSG);
    }

    private boolean isSameCenterX(final Points points) {
        return ((points.get(1).getX() + points.get(2).getX()) / 2) == ((points.get(0).getX() + points.get(3).getX()) / 2);
    }

    private boolean isSameCenterY(final Points points) {
        return ((points.get(1).getY() + points.get(2).getY()) / 2) == ((points.get(0).getY() + points.get(3).getY()) / 2);
    }

    private boolean isSameDiagonal(final Points points) {
        return calculateLine(points.get(1), points.get(2)) == calculateLine(points.get(0), points.get(3));
    }

    public double calculateLine(final Point point1, final Point point2) {
        return Math.sqrt(Math.pow((point1.getX() - point2.getX()), SQUARE) + Math.pow((point1.getY() - point2.getY()), SQUARE));
    }

    @Override
    public Double calculate() {
        return calculateLine(point1, point2) * calculateLine(point1, point3);
    }
}
