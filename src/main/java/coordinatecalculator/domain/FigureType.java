package coordinatecalculator.domain;

public enum FigureType {
    LINE(2),
    TRIANGLE(3),
    RECTANGLE(4);

    private static final String ERROR_INSUFFICIENT_POINTS = "입력한 좌표로는 '선', '삼각형', '직사각형'을 만들 수 없습니다.";

    private int pointCount;

    FigureType(int pointCount) {
        this.pointCount = pointCount;
    }

    public static FigureType valueOf(int pointCount) {
        for (FigureType value : values()) {
            if (value.pointCount == pointCount) {
                return value;
            }
        }
        throw new IllegalArgumentException(ERROR_INSUFFICIENT_POINTS);
    }
}
