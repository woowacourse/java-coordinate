package location.view;

import java.util.Arrays;

public enum ShapeMsgEnum {
    LINE(2, "두 점 사이의 거리는"),
    Triangle(3, "삼각형의 넓이는"),
    Rectangle(4, "사각형의 넓이는");

    private final static String NOT_MATCH_SHAPE_MSG = "해당하는 도형이 없습니다.";
    private final int pointLength;
    private final String msg;

    ShapeMsgEnum(int pointLength, String msg) {
        this.pointLength = pointLength;
        this.msg = msg;
    }

    public static String valueOf(int pointLength) {
        return Arrays.stream(values())
                .filter(shape -> shape.pointLength == pointLength).findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_MATCH_SHAPE_MSG)).msg;
    }
}
