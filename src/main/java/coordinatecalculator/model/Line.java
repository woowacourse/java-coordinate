package coordinatecalculator.model;

public class Line extends Figure {
    private double distance;

    public Line(Points points) {
        this.distance = points.getDistance(0, 1).getDistance();
    }

    @Override
    public double area() {
        return Math.round(distance * 1000) / 1000;
    }

    @Override
    public String toString() {
        return "두 점 사이의 거리는 " + distance;
    }
}
