package coordinate.domain;

public enum ShapeType {
    LINE(2),
    TRIANGLE(3),
    RECTANGLE(4);

    private final int pointSize;

    ShapeType(int pointSize) {
        this.pointSize = pointSize;
    }

    public static ShapeType vauleOf(int pointSize) {
        for (ShapeType shapeType : ShapeType.values()) {
            if (pointSize == shapeType.pointSize) {
                return shapeType;
            }
        }
        return null;
    }
}
