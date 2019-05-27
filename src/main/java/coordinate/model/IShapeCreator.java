package coordinate.model;

import java.util.List;

public class IShapeCreator {
        public static IShape create(List<Point> points) {
                try {
                        return IShape.MAPPING_SHAPE.get(points.size()).apply(points);
                } catch (IllegalArgumentException e) {
                        System.err.println(e.getMessage());
                        return create(points);
                }
        }
}
