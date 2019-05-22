package location.domain;

public class ShapeMaker {

    private final static String NOT_CREATE_SHAPE_MSG = "도형을 만들수 없습니다.";

    public static Shape create(Points points) {
        if(points.size() == 2){
            return new Line(points);
        }
        if(points.size() == 3){
            return new Triangle(points);
        }
        if(points.size() == 4){
            return new Rectangle(points);
        }
        throw new IllegalArgumentException(NOT_CREATE_SHAPE_MSG);
    }
}
