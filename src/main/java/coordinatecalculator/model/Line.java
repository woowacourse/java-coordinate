package coordinatecalculator.model;

public class Line implements Figure {

    private static final int FIRST_POINT_INDEX = 0;
    private static final int SECOND_POINT_INDEX = 1;
    private final Distance distance;
    private final Points points;

    public Line(Points points) {
        this.points = points;
        this.distance = points.getPointByIndex(FIRST_POINT_INDEX).getDistance(points.getPointByIndex(SECOND_POINT_INDEX));
    }

    @Override
    public double getArea() {
        return distance.getDistance();
    }

    @Override
    public String getResultForPrint() {
        return "두 점 사이의 거리는 " + getArea();
    }

    @Override
    public String toString() {
        return points + "두 점 사이의 거리 :" + distance;
    }
}
