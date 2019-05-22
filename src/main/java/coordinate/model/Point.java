package coordinate.model;

public class Point {
    private PointNumber x;
    private PointNumber y;

    public Point(PointNumber x, PointNumber y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(Point point2) {
        return Math.sqrt(Math.pow(this.x.getNumber() - point2.x.getNumber(), 2)
        + Math.pow(this.y.getNumber() - point2.y.getNumber(), 2));
    }
}
