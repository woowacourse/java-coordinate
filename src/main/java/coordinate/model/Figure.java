package coordinate.model;

import java.util.List;

public abstract class Figure implements Shape {

    private Points points;

    public Figure(List<Point> points) {
        this.points = new Points(points);
    }

    public double getDistance(int index1, int index2) {
        return Math.sqrt(Math.pow(points.minusX(index1, index2), 2)
                + Math.pow(points.minusY(index1, index2), 2));
    }

    public double getIncline(int index1, int index2) {
        if (points.isEqualX(index1, index2)) {
            return Double.MAX_VALUE;
        }
        return (double) (points.minusY(index1, index2)) / (points.minusX(index1, index2));
    }

    public Points getPoints() {
        return points;
    }
}
