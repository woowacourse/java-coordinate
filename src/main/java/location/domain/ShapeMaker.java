package location.domain;

public class ShapeMaker {
    public static Shape create(Points points) {
        return ShapeEnum.valueOf(points.size()).create(points);
    }
}
