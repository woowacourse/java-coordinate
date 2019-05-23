package coordinate.view;

import coordinate.domain.point.PointGroup;
import org.apache.commons.lang3.StringUtils;

class CoordinatePlaneDrawer {
    private static final int COORDINATE_PLANE_SIZE = 24;
    private static final int HORIZONTAL_RATIO = 3;
    private static final String HORIZONTAL_LINE = "|";
    private static final String VERTICAL_LINE = "-";
    private static final String EMPTY = " ";
    private static final String ORIGIN = "+";
    private static final String COORDINATES = "@";
    private static final String NEW_LINE = "\n";

    private final StringBuilder drawer;

    CoordinatePlaneDrawer(int coordinatePlaneSize, PointGroup points) {
        drawer = new StringBuilder();

        for (int i = coordinatePlaneSize; i > 0; i--) {
            drawRow(i, points);
        }
        drawOrigin(points.have(0, 0));
        drawXAxis(points);
    }

    private void drawRow(int rowNumber, PointGroup points) {
        drawer.append(drawAxisNumber(rowNumber));
        drawer.append(drawYAxis(rowNumber, points));
        for (int i = 1; i <= COORDINATE_PLANE_SIZE; i++) {
            drawer.append(drawPoint(points.have(i, rowNumber)));
        }
        drawer.append(NEW_LINE);
    }

    private String drawAxisNumber(int number) {
        if (number % 2 == 0) {
            return StringUtils.center(String.valueOf(number), HORIZONTAL_RATIO);
        }
        return StringUtils.repeat(EMPTY, HORIZONTAL_RATIO);
    }

    private String drawYAxis(int rowNumber, PointGroup points) {
        if (points.have(0, rowNumber)) {
            return COORDINATES;
        }
        return HORIZONTAL_LINE;
    }

    private String drawPoint(boolean havePoint) {
        if (havePoint) {
            return StringUtils.center(COORDINATES, HORIZONTAL_RATIO);
        }
        return StringUtils.repeat(EMPTY, HORIZONTAL_RATIO);
    }

    private void drawOrigin(boolean havePoint) {
        drawer.append(StringUtils.repeat(EMPTY, HORIZONTAL_RATIO));
        if (havePoint) {
            drawer.append(COORDINATES);
            return;
        }
        drawer.append(ORIGIN);
    }

    private void drawXAxis(PointGroup points) {
        for (int i = 1; i <= COORDINATE_PLANE_SIZE; i++) {
            drawXAxisLine(points.have(i, 0));
        }
        drawer.append(NEW_LINE);
        drawer.append(EMPTY);
        for (int i = 0; i <= COORDINATE_PLANE_SIZE; i++) {
            drawer.append(drawAxisNumber(i));
        }
        drawer.append(NEW_LINE);
    }

    private void drawXAxisLine(boolean havePoint) {
        if (havePoint) {
            drawer.append(StringUtils.center(COORDINATES, 3, VERTICAL_LINE));
            return;
        }
        drawer.append(StringUtils.repeat(VERTICAL_LINE, 3));
    }

    String print() {
        return drawer.toString();
    }
}
