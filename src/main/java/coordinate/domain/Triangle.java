package coordinate.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle extends Figure {
    private static final String NAME = "삼각형";
    private static final String OPERATION_NAME = "넓이";
    private static final int FIRST_POINT = 0;
    private static final int SECOND_POINT = 1;
    private static final int THIRD_POINT = 2;

    public Triangle(Points points) {
        super(points);
        if (points.size() != 3) {
            throw new IllegalArgumentException("4개의 점으로 구성되어야 합니다");
        }
        if (!isTriangle(points)) {
            throw new IllegalArgumentException("삼각형이 아닙니다");
        }
    }

    static boolean isTriangle(Points points) {
        List<Double> lineLengths = getLineLengths(points);
        return lineLengths.get(FIRST_POINT) + lineLengths.get(SECOND_POINT) > lineLengths.get(THIRD_POINT);
    }

    private static List<Double> getLineLengths(Points points) {
        List<Double> lineLengths = Arrays.asList(
                new Line(new Points(Arrays.asList(points.get(FIRST_POINT), points.get(SECOND_POINT)))).calculateFigure(),
                new Line(new Points(Arrays.asList(points.get(FIRST_POINT), points.get(THIRD_POINT)))).calculateFigure(),
                new Line(new Points(Arrays.asList(points.get(SECOND_POINT), points.get(THIRD_POINT)))).calculateFigure()
        );
        Collections.sort(lineLengths);
        return lineLengths;
    }

    public double calculateFigure() {
        List<Double> lineLengths = getLineLengths(points);
        double s = (lineLengths.get(FIRST_POINT) + lineLengths.get(SECOND_POINT) + lineLengths.get(THIRD_POINT)) / 2;
        return Math.sqrt(s * (s - lineLengths.get(FIRST_POINT)) *
                (s - lineLengths.get(SECOND_POINT)) *
                (s - lineLengths.get(THIRD_POINT)));
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
