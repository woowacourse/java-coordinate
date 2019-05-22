package location.domain;

public class Line extends Shape {
    private static final int SQUARE = 2;
    private final Point point1;
    private final Point point2;

    public Line(final Points points) {
        this.point1 = points.get(0);
        this.point2 = points.get(1);
    }

    @Override
    public Double calculate() {
        return Math.sqrt(Math.pow((point1.getX() - point2.getX()), SQUARE) + Math.pow((point1.getY() - point2.getY()), SQUARE));
    }
}
