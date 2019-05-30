package coordinate.domain;

import java.util.List;
import java.util.function.Function;

public enum AttributeType {
    STRAIGHT_LINE("두 점 사이의 거리는 ", 2, StraightLine::new),
    TRIANGLE("삼각형 넓이는", 3, Triangle::new),
    RECTANGLE("사각형 넓이는", 4, Rectangle::new);

    private String attributePrintMessage;
    private int numberOfPointInFigure;
    private Function<List<Point>, Figure> funcion;

    AttributeType(String attributePrintMessage, int numberOfPointInFigure, Function<List<Point>, Figure> function) {
        this.attributePrintMessage = attributePrintMessage;
        this.numberOfPointInFigure = numberOfPointInFigure;
        this.funcion = function;
    }

    public static String getPrintMessage(int numberOfPointInFigure) {
        for (AttributeType attributeType : values()) {
            if (attributeType.matchNumOfPoint(numberOfPointInFigure)) {
                return attributeType.attributePrintMessage;
            }
        }
        throw new IllegalArgumentException("해당 AttributeType 이 존재하지 않습니다.");
    }

    private boolean matchNumOfPoint(int numberOfPointInFigure) {
        return this.numberOfPointInFigure == numberOfPointInFigure;
    }

    public static Figure getFigureOf(List<Point> points) {
        for (AttributeType value : AttributeType.values()) {
            if (value.matchNumOfPoint(points.size())) {
                return value.funcion.apply(points);
            }
        }
        throw new IllegalArgumentException("정의되지 않은 도형입니다.");
    }
}