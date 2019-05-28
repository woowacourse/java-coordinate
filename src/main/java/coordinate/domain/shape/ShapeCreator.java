package coordinate.domain.shape;

import coordinate.domain.point.Point;

import java.util.List;

public interface ShapeCreator {
    Shape create(List<Point> points);
}
