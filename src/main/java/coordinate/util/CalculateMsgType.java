package coordinate.util;

import coordinate.domain.figure.Figure;
import coordinate.domain.figure.line.Line;
import coordinate.domain.figure.rectangle.Rectangle;
import coordinate.domain.figure.triangle.Triangle;

import java.util.Arrays;

public enum CalculateMsgType {
    LINE(Line.LINE_SIZE, "두 점 사이의 거리는 "),
    TRIANGLE(Triangle.TRIANGLE_SIZE, "삼각형의 넓이는 "),
    RECTANGLE(Rectangle.RECTANGLE_SIZE, "직사각형의 넓이는 ");

    private final int pointCount;
    private final String msg;

    CalculateMsgType(int pointCount, String msg) {
        this.pointCount = pointCount;
        this.msg = msg;
    }

    public static String messageOf(Figure figure) {
        return Arrays.stream(CalculateMsgType.values())
                .filter(x -> x.pointCount == figure.size())
                .findAny()
                .get()
                .msg;
    }
}
