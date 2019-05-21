package coordinate;

import java.util.Arrays;

import static coordinate.Line.createLine;
import static util.NotNullValidator.validateNotNull;

public class Triangle {
    private static final int POINTS_SIZE = 3;

    private final Points points;

    public Triangle(Points points) {
        validateNotNull(points);
        validateNumOf(points);
        this.points = points;
    }

    private void validateNumOf(Points points) {
        if (points.getSize() != POINTS_SIZE) {
            throw new IllegalArgumentException("삼각형은 3개의 점을 가져야 합니다.");
        }
    }

    public boolean checkSameSlope() {
        return Double.compare(createLine(points.get(0), points.get(1)).calculateSlope()
                , createLine(points.get(1), points.get(2)).calculateSlope()) == 0;
    }

    public double area() {

        //double l1 = createLine(points.get(0), points.get(1)).calculateDistance();
        double l1 = new Line(new Points(Arrays.asList(points.get(0), points.get(1)))).calculateDistance();
        double l2 = new Line(new Points(Arrays.asList(points.get(1), points.get(2)))).calculateDistance();
        double l3 = new Line(new Points(Arrays.asList(points.get(2), points.get(0)))).calculateDistance();

        double s = (l1 + l2 + l3) / 2;
        return Math.sqrt((s * (s - l1) * (s - l2) * (s - l3)));
    }
}