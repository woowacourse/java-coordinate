package coordinatecalculator.model.coordinate;

import java.util.ArrayList;
import java.util.List;

public class CoordinatePlane {
    private static final int WIDTH = 24;
    private static final int HEIGHT = 24;
    private static final int NUMBER_OFFSET = 0;
    private static final int STRIDE = 2;
    private static final char POINT = 'o';
    private static final String WHITE_SPACE = "  ";
    private static final String NEW_LINE = "\n";
    private static final String Y_AXIS = "| ";
    private static final String X_AXIS_START = "  +-";
    private static final String X_AXIS_LINE = "--";
    private static final String ZERO = " 0 ";
    private static final String NUMBER_FORMAT = "%2d";

    private List<StringBuilder> plane = new ArrayList<>();

    public CoordinatePlane(Coordinates coordinates) {
        drawDefaultPlane();
        insertPoints(coordinates);
        insertNumbers();
    }

    private void insertPoints(Coordinates coordinates) {
        for (int i = 0, len = coordinates.size(); i < len; i++) {
            int y = HEIGHT - coordinates.get(i).getY();
            plane.get(y).setCharAt(coordinates.get(i).getX() * STRIDE, POINT);
        }
    }

    private void drawDefaultPlane() {
        addYAxis();
        addXAxis();
    }

    private void addYAxis() {
        for (int i = 0; i < HEIGHT; i++) {
            StringBuilder stringBuilder = new StringBuilder(Y_AXIS);
            appendWhiteSpaces(stringBuilder, WIDTH);
            plane.add(stringBuilder);
        }
    }

    private void addXAxis() {
        StringBuilder stringBuilder = new StringBuilder(X_AXIS_START);
        for (int i = 0; i < WIDTH; i++) {
            stringBuilder.append(X_AXIS_LINE);
        }
        plane.add(stringBuilder);
    }

    private void appendWhiteSpaces(StringBuilder stringBuilder, int count) {
        for (int i = 0; i < count; i++) {
            stringBuilder.append(WHITE_SPACE);
        }
    }

    private void insertNumbers() {
        insertYAxisNumber();
        insertXAxisNumber();
    }

    private void insertYAxisNumber() {
        for (int i = 0; i < HEIGHT; i += STRIDE) {
            int index = Math.abs(HEIGHT - i);
            plane.get(i).insert(NUMBER_OFFSET, String.format(NUMBER_FORMAT, index));
            plane.get(i + 1).insert(NUMBER_OFFSET, WHITE_SPACE);
        }
    }

    private void insertXAxisNumber() {
        StringBuilder stringBuilder = new StringBuilder(ZERO);
        for (int i = 1; i <= WIDTH; i += STRIDE) {
            stringBuilder.append(WHITE_SPACE);
            stringBuilder.append(String.format(NUMBER_FORMAT, i + 1));
        }
        plane.add(stringBuilder);
    }

    @Override
    public String toString() {
        return plane.stream()
                .reduce(new StringBuilder(), (previous, next) -> previous.append(next).append(NEW_LINE))
                .toString();
    }
}
