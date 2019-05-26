package coordinate.model;

import java.util.List;

public class Line extends Figure {

    public Line(List<Point> points) {
        super(points);
    }

    @Override
    public double getScore() {
        return super.getPoint(0).getDistance(super.getPoint(1));
    }
}
