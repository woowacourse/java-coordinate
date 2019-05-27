package coordinate.model.framework;

import coordinate.model.Points;

public class IShapeCreator {
        public static IShape create(Points points) {
                return IShape.MAPPING_SHAPE.get(points.getPoints().size()).apply(points.getPoints());
        }
}
