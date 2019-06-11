package coordinate.domain;

import java.util.List;

public class StraightLine extends Figure {
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 1;
    private static final int NUM_OF_POINT = 2;

    StraightLine(List<Point> points) {
        super(points, NUM_OF_POINT);
    }

    @Override
    public double calculateAttribute() {
        return calculateLength();
    }

    double calculateLength() {
        return calculateLength(START_INDEX, END_INDEX);
    }
}