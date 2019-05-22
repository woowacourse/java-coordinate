package coordinate.domain;


public class Line extends Figure implements Comparable<Line> {
    private Coordinate coordinate;
    private Double length;

    public Line(Coordinate coordinate) {
        this.coordinate = coordinate;
        this.length = findArea();
    }

    @Override
    double findArea() {
        Point firstPoint = coordinate.getPoint(0);
        Point secondPoint = coordinate.getPoint(1);
        return Math.sqrt(Math.pow(firstPoint.sub_x(secondPoint), 2)
                + Math.pow(firstPoint.sub_y(secondPoint), 2));
    }

    @Override
    public int compareTo(Line o) {
        return (int) (o.length - this.length);
    }
}
