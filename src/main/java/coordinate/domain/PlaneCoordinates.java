package coordinate.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaneCoordinates {
    private static final String NEXT_LINE = "\n";
    private static final int MIN_SPACE_FOR_EACH_X = 2;
    private static final int MIN_SPACE_FOR_Y_AXIS = 4;
    private static final int SPACE_FOR_X_SCALE = 2;
    private static final String DEFAULT_INDICATOR = "*";
    private static final String UNIT_Y_AXIS = "|";
    private static final char UNIT_FOR_X_AXIS = '―';

    private final int spacePerX;
    private final int spaceForYAxis;

    private List<StringBuilder> plane;

    PlaneCoordinates(int maxX, int maxY) {
        spacePerX = Math.max(MIN_SPACE_FOR_EACH_X, Integer.toString(maxX).length());
        spaceForYAxis = Math.max(MIN_SPACE_FOR_Y_AXIS, Integer.toString(maxY).length() + 1);
        drawEmptyPlane(maxX, maxY);
    }

    private void drawEmptyPlane(int maxX, int maxY) {
        plane = new ArrayList<>();
        for (int i = maxY; i > 0; i--) {
            plane.add(makeLine(i, maxX));
        }
        plane.add(makeXAxis(maxX));
        plane.add(makeXScale(maxX));
    }

    private StringBuilder makeLine(int y, int maxX) {
        String axisFormat = "%" + (spaceForYAxis - 1) + "s" + UNIT_Y_AXIS + "%" + (maxX * spacePerX) + "s";
        return new StringBuilder(String.format(axisFormat, (y % 2 == 0) ? Integer.toString(y) : "", ""));
    }


    private StringBuilder makeXAxis(int maxX) {
        StringBuilder xAxis = new StringBuilder(String.format("%" + spaceForYAxis + "s", "+"));
        char[] chars = new char[maxX * spacePerX];
        Arrays.fill(chars, UNIT_FOR_X_AXIS);
        xAxis.append(chars);

        return xAxis;
    }

    private StringBuilder makeXScale(int maxX) {
        StringBuilder xScale = new StringBuilder(String.format("%" + spaceForYAxis + "s", "0 "));
        for (int i = 2; i <= maxX; i += 2) {
            xScale.append(String.format("%" + (spacePerX * 2) + "d", i));
        }
        return xScale;
    }

    PlaneCoordinates plotPoints(List<Point> points) {
        points.forEach(this::plotPoint);
        return this;
    }

    private void plotPoint(Point point) {
        int planeIndexOfX = spaceForYAxis + spacePerX * point.getX();
        int planeIndexOfY = plane.size() - SPACE_FOR_X_SCALE - point.getY();
        plane.get(planeIndexOfY).replace(planeIndexOfX - DEFAULT_INDICATOR.length(), planeIndexOfX, DEFAULT_INDICATOR);
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        plane.forEach(line -> stringBuilder.append(line).append(NEXT_LINE));
        return stringBuilder.toString();
    }
}
