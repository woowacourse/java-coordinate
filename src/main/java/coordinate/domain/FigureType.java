package coordinate.domain;

public enum FigureType {
    LINE(2),
    TRIANGLE(3),
    RECTANGLE(4);

    private final int numOfPoints;

    FigureType(int numOfPoints) {
        this.numOfPoints = numOfPoints;
    }

    public static FigureType valueOf(int numOfPoints) {
        for (FigureType type : values()) {
            if (type.numOfPoints == numOfPoints) {
                return type;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 도형입니다.");
    }
}
