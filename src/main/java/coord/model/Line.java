package coord.model;

import java.util.Arrays;

public class Line {
    private final Points points;

    public Line(Points points) {
        this.points = points;
    }

    public Line(Point A, Point B) {
        points = new Points(Arrays.asList(A, B));
    }


    public double length() {
        Point A = points.get(0);
        Point B = points.get(1);
        return Distance.length(A, B);
    }
}