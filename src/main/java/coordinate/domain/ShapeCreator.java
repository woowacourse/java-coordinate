package coordinate.domain;

import java.util.List;

public interface ShapeCreator {
    Shape create(List<Point> points);
}
