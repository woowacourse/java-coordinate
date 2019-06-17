package coordinate.domain;

import java.util.List;

@FunctionalInterface
public interface ShapeCreator {
    Shape create(List<Point> points);
}
