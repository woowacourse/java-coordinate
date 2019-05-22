package coordinate.domain;

public class Line {
    private final Point firstPoint;
    private final Point secondPoint;

    public Line(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }

    public double calLength() {
        return firstPoint.sub(secondPoint);
    }
}
