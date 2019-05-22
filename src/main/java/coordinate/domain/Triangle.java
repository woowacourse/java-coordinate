package coordinate.domain;

public class Triangle {
    private final Points points;

    public Triangle(Points points) {
        this.points = points;
    }

    public double getArea() {
        double a = points.getPoints(0).calculateDistance(points.getPoints(1));
        double b = points.getPoints(0).calculateDistance(points.getPoints(2));
        double c = points.getPoints(1).calculateDistance(points.getPoints(2));
        double s = (a + b + c) / 2;
        return Math.round((Math.sqrt(s * (s - a) * (s - b) * (s - c)) * 1000)) / 1000;
    }
}
