package location.domain;

import java.util.Arrays;

public enum FigureEnum {
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

    FigureEnum(int pointLength) {
        this.pointLength = pointLength;
    }

    public static FigureEnum valueOf(int pointLength) {
        return Arrays.stream(values())
                .filter(figure -> figure.isSameLength(pointLength)).findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_CREATE_SHAPE_MSG));
    }

    public boolean isSameLength(int pointLength){
        return this.pointLength == pointLength;
    }

    public Figure create(Points points) {
        return null;
    }

}
