package coordinate.model;

import java.util.List;

public class Line extends Figure {

    public Line(List<Point> points) {
        super(points);
    }

    @Override
    public double getScore() {
        return getDistance(0, 1);
    }
}
