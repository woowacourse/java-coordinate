package location.domain;

import java.util.Arrays;

public enum ShapeEnum {
    LINE(2) {
        public Figure create(Points points) {
            return new Line(points);
        }
    }, Triangle(3) {
        public Figure create(Points points) {
            return new Triangle(points);
        }
    }, Rectangle(4) {
        public Figure create(Points points) {
            return new Rectangle(points);
        }
    };

    private final static String NOT_CREATE_SHAPE_MSG = "도형을 만들수 없습니다.";
    private final int pointLength;

    ShapeEnum(int pointLength) {
        this.pointLength = pointLength;
    }

    public static ShapeEnum valueOf(int pointLength) {
        return Arrays.stream(values())
                .filter(shape -> shape.pointLength == pointLength)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_CREATE_SHAPE_MSG));
    }

    public abstract Figure create(Points points);
}
