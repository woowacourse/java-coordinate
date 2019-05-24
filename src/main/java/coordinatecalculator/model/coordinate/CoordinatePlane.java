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

    private List<StringBuilder> plane;

    public CoordinatePlane(Coordinates coordinates) {
        List<StringBuilder> plane = drawDefaultPlane();
        insertPoints(plane, coordinates);
        insertNumbers(plane);
        this.plane = plane;
    }

    private void insertPoints(List<StringBuilder> defaultPlane, Coordinates coordinates) {
        for (int i = 0, len = coordinates.size(); i < len; i++) {
            int y = Math.abs(HEIGHT - coordinates.get(i).getY());
            defaultPlane.get(y).setCharAt(coordinates.get(i).getX() * STRIDE, POINT);
        }
    }

    private List<StringBuilder> drawDefaultPlane() {
        List<StringBuilder> plane = new ArrayList<>();
        addYAxis(plane);
        addXAxis(plane);
        return plane;
    }

    private void addYAxis(List<StringBuilder> plane) {
        for (int i = 0; i < HEIGHT; i++) {
            StringBuilder stringBuilder = new StringBuilder(Y_AXIS);
            appendWhiteSpaces(stringBuilder, WIDTH);
            plane.add(stringBuilder);
        }
    }

    private void addXAxis(List<StringBuilder> plane) {
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

    private void insertNumbers(List<StringBuilder> plane) {
        insertYAxisNumber(plane);
        insertXAxisNumber(plane);
    }

    private void insertYAxisNumber(List<StringBuilder> plane) {
        for (int i = 0; i < HEIGHT; i++) {
            insertNumber(plane, i);
        }
    }

    private void insertXAxisNumber(List<StringBuilder> plane) {
        StringBuilder stringBuilder = new StringBuilder(ZERO);
        for (int i = 1; i <= WIDTH; i++) {
            appendNumber(stringBuilder, i);
        }
        plane.add(stringBuilder);
    }

    private void insertNumber(List<StringBuilder> plane, int number) {
        int index = Math.abs(HEIGHT - number);
        if (isEvenNumber(number)) {
            plane.get(number).insert(NUMBER_OFFSET, String.format(NUMBER_FORMAT, index));
            return;
        }
        plane.get(number).insert(NUMBER_OFFSET, WHITE_SPACE);
    }

    private void appendNumber(StringBuilder stringBuilder, int number) {
        if (isEvenNumber(number)) {
            stringBuilder.append(String.format(NUMBER_FORMAT, number));
            return;
        }
        stringBuilder.append(WHITE_SPACE);
    }

    private boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }

    @Override
    public String toString() {
        return plane.stream()
                .reduce(new StringBuilder(), (previous, next) -> previous.append(next + NEW_LINE))
                .toString();
    }
}
