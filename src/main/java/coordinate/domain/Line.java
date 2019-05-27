package coordinate.domain;

public class Line extends Figure {
    private static final String NAME = "선";
    private static final String OPERATION_NAME = "길이";

    public Line(Points points) {
        super(points);
        if (points.size() != 2) {
            throw new IllegalArgumentException("2개의 점으로 구성되어야 합니다");
        }
    }

    @Override
    public double calculateFigure() {
        return points.get(0).sub(points.get(1));
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getOperationName() {
        return OPERATION_NAME;
    }
}
