package coordinatecalculator.model;

public class Line implements Figure {

    private double distance;

    public Line(Points points) {
        this.distance = points.getDistance(0, 1).getDistance();
    }

    @Override
    public double getArea() {
        return distance;
    }

    @Override
    public String toString() {
        return "두 점 사이의 거리는 " + distance;
    }
}
