package coordinate.util;

import coordinate.domain.figure.Figure;
import coordinate.domain.point.Point;
import org.apache.commons.lang3.StringUtils;

public class CoordinatePlaneDrawer {
    private static final int COORDINATE_PLANE_SIZE = 24;
    private static final int HORIZONTAL_RATIO = 3;
    private static final String HORIZONTAL_LINE = "|";
    private static final String VERTICAL_LINE = "—";
    private static final String EMPTY = " ";
    private static final String ORIGIN = "+";
    private static final String COORDINATES = "•";
    private static final String NEW_LINE = "\n";

    private final StringBuilder drawer;

    public CoordinatePlaneDrawer(Figure figure) {
        drawer = new StringBuilder();

        for (int i = COORDINATE_PLANE_SIZE; i > 0; i--) {
            drawRow(i, figure);
        }
        drawOrigin(figure.have(Point.create(0, 0)));
        drawXAxis(figure);
    }

    private void drawRow(int rowNumber, Figure figure) {
        drawer.append(drawAxisNumber(rowNumber));
        drawer.append(drawYAxis(rowNumber, figure));
        for (int i = 1; i <= COORDINATE_PLANE_SIZE; i++) {
            drawer.append(drawPoint(figure.have(Point.create(i, rowNumber))));
        }
        drawer.append(NEW_LINE);
    }

    private String drawAxisNumber(int number) {
        if (number % 2 == 0) {
            return StringUtils.center(String.valueOf(number), HORIZONTAL_RATIO);
        }
        return StringUtils.repeat(EMPTY, HORIZONTAL_RATIO);
    }

    private String drawYAxis(int rowNumber, Figure figure) {
        if (figure.have(Point.create(0, rowNumber))) {
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

    private void drawXAxis(Figure figure) {
        for (int i = 1; i <= COORDINATE_PLANE_SIZE; i++) {
            drawXAxisLine(figure.have(Point.create(i, 0)));
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
            drawer.append(StringUtils.center(COORDINATES, HORIZONTAL_RATIO, VERTICAL_LINE));
            return;
        }
        drawer.append(StringUtils.repeat(VERTICAL_LINE, HORIZONTAL_RATIO));
    }

    public String print() {
        return drawer.toString();
    }
}
