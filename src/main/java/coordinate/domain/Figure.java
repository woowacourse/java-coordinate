package coordinate.domain;

import java.util.Collections;
import java.util.List;

public abstract class Figure implements Calculable {
    protected Points points;

    public Figure(Points points) {
        this.points = points;
    }

    public List<Point> getPoints() {
        return Collections.unmodifiableList(points.getPoint());
    }
}
