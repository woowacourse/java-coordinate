package coordinate.domain;

import java.util.Arrays;

public enum FigureMessage {
    LINE(2, "두 점 사이의 거리는 : "),
    TRIANGLE(3, "삼각형의 넓이는 : "),
    RECTANGLE(4, "사각형의 넓이는 : ");

    private int numberOfPoints;
    private String resultMessage;

    FigureMessage(int numberOfPoints, String resultMessage) {
        this.numberOfPoints = numberOfPoints;
        this.resultMessage = resultMessage;
    }

    public static String getResultMessage(Figure figure) {
        return Arrays.stream(values())
                .filter(shape -> shape.match(figure.getPoints().size()))
                .findFirst()
                .get().resultMessage;
    }

    private boolean match(int pointsSize) {
        return this.numberOfPoints == pointsSize;
    }
}
