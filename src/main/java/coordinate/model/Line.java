package coordinate.model;

import java.util.List;

public class Line extends Figure {

    public Line(List<Point> points) {
        super(points);
    }

    @Override
    public double getScore() {
        return points.get(0).getDistance(points.get(1));
    }
}
