package coordinate.model;

import java.util.List;

public class Line {
    private List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    public double getLength(){
        return points.get(0).getDistance(points.get(1));
    }
}
