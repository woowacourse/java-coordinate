package coordinatecalculator.model;

enum FigureType { // 굳이 이렇게 할 필요는 없지만, enum 수업을 들었으니 연습삼아.
    POINT(1),
    LINE(2),
    TRIANGLE(3),
    RECTANGLE(4);

    private final int pointsCount;

    FigureType(int pointsCount) {
        this.pointsCount = pointsCount;
    }

    static FigureType valueOf(int pointsCount) throws IllegalArgumentException {
        for (FigureType value : values()) {
            if (value.pointsCount == pointsCount) {
                return value;
            }
        }
        throw new IllegalArgumentException("유효하지 않은 도형입니다.");
    }
}