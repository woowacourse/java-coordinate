package coordinatecalculator.model.coordinate;

import java.util.ArrayList;
import java.util.List;

public class CoordinatePlane {
    private static final int WIDTH = 24;
    private static final int HEIGHT = 24;
    private static final int AXIS_SCALE = 2;
    private static final char POINT = '*';
    private static final String X_AXIS_LINE = "--";
    private static final String Y_AXIS_LINE = "|";
    private static final String ORIGIN = "+";
    private static final String ORIGIN_VALUE = "0";
    private static final String PLANE_SPACE = "  ";
    private static final int SPACE_STRIDE = 2;
    private static final String AXIS_VALUE_SPACE = "  ";
    private static final String AXIS_VALUE_FORMAT = "%2d";
    private static final String NEW_LINE = "\n";

    private List<StringBuilder> plane = new ArrayList<>();

    public CoordinatePlane() {
        generateDefaultPlane();
    }

    private void generateDefaultPlane() {
        addYAxis();
        addXAxis();
    }

    private void addYAxis() {
        for (int i = 0; i < HEIGHT; i++) {
            StringBuilder dy = new StringBuilder(AXIS_VALUE_SPACE + Y_AXIS_LINE);
            appendPlaneSpace(dy);
            plane.add(dy);
        }
    }

    private void appendPlaneSpace(StringBuilder dy) {
        for (int i = 0; i < WIDTH; i++) {
            dy.append(PLANE_SPACE);
        }
    }

    private void addXAxis() {
        StringBuilder xAxis = new StringBuilder(AXIS_VALUE_SPACE + ORIGIN);
        for (int i = 0; i < WIDTH; i++) {
            xAxis.append(X_AXIS_LINE);
        }
        plane.add(xAxis);
    }

    public void pointCoordinates(Coordinates coordinates) {
        for (Coordinate coordinate : coordinates.getCoordinates()) {
            int ySearchIndex = HEIGHT - coordinate.getY();
            int xSearchIndex = coordinate.getX();
            plane.get(ySearchIndex)
                    .setCharAt(AXIS_VALUE_SPACE.length() + xSearchIndex * SPACE_STRIDE, POINT);
        }
    }

    private void addYAxisValues() {
        for (int i = 0; i < HEIGHT; i = i + AXIS_SCALE) {
            int axisValue = HEIGHT - i;
            plane.get(i).replace(0, 2, String.format(AXIS_VALUE_FORMAT, axisValue));
        }
    }

    private void addXAxisValues() {
        StringBuilder xAxisValues = new StringBuilder(AXIS_VALUE_SPACE + ORIGIN_VALUE);
        for (int i = AXIS_SCALE; i <= WIDTH; i = i + AXIS_SCALE) {
            xAxisValues.append(AXIS_VALUE_SPACE);
            xAxisValues.append(String.format(AXIS_VALUE_FORMAT, i));
        }
        plane.add(xAxisValues);
    }

    @Override
    public String toString() {
        addYAxisValues();
        addXAxisValues();

        return plane.stream()
                .reduce(new StringBuilder(), (previous, next) -> previous.append(next + NEW_LINE))
                .toString();
    }
}
