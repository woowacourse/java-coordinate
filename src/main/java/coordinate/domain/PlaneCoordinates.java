package coordinate.domain;

import java.util.ArrayList;
import java.util.List;

public class PlaneCoordinates {
    private static final int MAX_X_VALUE = 24;
    private static final int MAX_Y_VALUE = 24;
    public static final String NEXT_LINE = "\n";

    private final StringBuilder xScale;
    private List<StringBuilder> plane;

    public PlaneCoordinates() {
        xScale = makeXScale();
        plane = new ArrayList<>();
        plane.add(makeXAxis());

        for (int i = 1; i <= MAX_Y_VALUE; i += 2) {
            plane.add(makeOddLine());
            plane.add(makeEvenLine(i));
        }
    }

    public PlaneCoordinates(List<Point> points) {
        this();
        for (Point point : points) {
            plane.get(point.getY()).replace(4 + (2 * point.getX()) - 1, 4 + (2 * point.getX()), "*");
        }
    }

    private StringBuilder makeXScale() {
        StringBuilder xScale = new StringBuilder("  0 ");
        for (int i = 2; i <= MAX_X_VALUE; i += 2) {
            xScale.append(String.format("%4d", i));
        }

        return xScale;
    }

    private StringBuilder makeXAxis() {
        StringBuilder xAxis = new StringBuilder("   +");
        for (int i = 2; i <= MAX_X_VALUE; i += 2) {
            xAxis.append("――――");
        }

        return xAxis;
    }

    private StringBuilder makeOddLine() {
        StringBuilder oddLine = new StringBuilder("   |");
        oddLine.setLength(4 + 2 * MAX_X_VALUE);

        return oddLine;
    }

    private StringBuilder makeEvenLine(int i) {
        StringBuilder evenLine = new StringBuilder(String.format("%3d|", i + 1));
        evenLine.setLength(4 + 2 * MAX_X_VALUE);

        return evenLine;
    }

    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();

        for (int i = 24 ; i >= 0; i--) {
            temp.append(plane.get(i)).append(NEXT_LINE);
        }
        temp.append(xScale);

        return temp.toString();
    }
}
