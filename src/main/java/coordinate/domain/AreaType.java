package coordinate.domain;

import java.util.Arrays;

public enum AreaType {
    STRAIGHT_LINE("두 점 사이의 거리는 ", 2),
    TRIANGLE("삼각형 넓이는 ", 3),
    RECTANGLE("사각형 넓이는 ", 4);

    private String attributePrintMessage;
    private int numberOfPointInFigure;

    AreaType(String attributePrintMessage, int numberOfPointInFigure) {
        this.attributePrintMessage = attributePrintMessage;
        this.numberOfPointInFigure = numberOfPointInFigure;
    }

    public static String getAreaTypeMessage(int numberOfPointInFigure) {
        AreaType type = Arrays.stream(values())
                .filter(areaType -> areaType.matchNumOfPoint(numberOfPointInFigure))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 AreaType 이 존재하지 않습니다."));

        return type.attributePrintMessage;
    }

    private boolean matchNumOfPoint(int numberOfPointInFigure) {
        return this.numberOfPointInFigure == numberOfPointInFigure;
    }
}
