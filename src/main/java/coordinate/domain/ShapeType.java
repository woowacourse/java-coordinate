package coordinate.domain;

public enum ShapeType {
    LINE(2),
    TRIANGLE(3),
    RECTANGLE(4);

    private final int pointSize;

    ShapeType(int pointSize) {
        this.pointSize = pointSize;
    }

    public static ShapeType valueOf(int pointSize) {
        for (ShapeType shapeType : ShapeType.values()) {
            if (pointSize == shapeType.pointSize) {
                return shapeType;
            }
        }
        throw new IllegalArgumentException("포인트 개수의 모양이 없습니다.");
    }

    public int getPointSize() {
        return pointSize;
    }
}
