package coordinate.domain;

import java.util.List;

public abstract class Figure {
    Points points;

    Figure(Points points) {
        validateConfigurableBy(points);
        this.points = points;
    }

    abstract void validateConfigurableBy(Points points);

    public List<Point> getPoints() {
        return points.getAllPoints();
    }

    public int getNumOfPoints() {
        return points.size();
    }
}
