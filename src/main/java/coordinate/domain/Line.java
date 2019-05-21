package coordinate.domain;

public class Line {
    private final Point startPoint;
    private final Point endPoint;

    public Line(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public double length() {
        return startPoint.calculateDistance(endPoint);
    }
}
