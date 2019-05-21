package coordinate.domain;

public class Line extends Figure {
    private Coordinate coordinate;

    public Line(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    double findArea() {
        Point firstPoint = coordinate.getPoint(0);
        Point secondPoint = coordinate.getPoint(1);
        return Math.sqrt(Math.pow(firstPoint.getPoint_x() - secondPoint.getPoint_x(),2)
                + Math.pow(firstPoint.getPoint_y() - secondPoint.getPoint_y() , 2));
    }
}
