package coordinate.util;

import coordinate.domain.figure.Figure;
import coordinate.domain.figure.Line;
import coordinate.domain.figure.Rectangle;
import coordinate.domain.figure.Triangle;

import java.util.Arrays;

public enum CalculateMsgType {
    LINE(Line.POINT_COUNT, "두 점 사이의 거리는 "),
    TRIANGLE(Triangle.POINT_COUNT, "삼각형의 넓이는 "),
    RECTANGLE(Rectangle.POINT_COUNT, "직사각형의 넓이는 ");

    private final int pointCount;
    private final String msg;

    CalculateMsgType(int pointCount, String msg) {
        this.pointCount = pointCount;
        this.msg = msg;
    }

    public static String messageOf(Figure figure) {
        return Arrays.stream(CalculateMsgType.values())
                .filter(x -> x.pointCount == figure.getPointCount())
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("결과를 지원하지 않는 도형입니다."))
                .msg;
    }
}
