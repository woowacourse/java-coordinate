package coordinate.domain;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private static final int MAX_WIDTH = 24;
    private static final String VERTICAL_AXIS = "|";
    private static final String POINT = " *";
    private static final String BLANK = "  ";
    private static final int EXTRA_INDEX = 1;

    private List<String> nthRow = new ArrayList<>();

    public Row(int height) {
        nthRow.add(String.format("%2s", String.valueOf(height)));
        nthRow.add(VERTICAL_AXIS);
        for (int i = 0; i < MAX_WIDTH; i++) {
            nthRow.add(BLANK);
        }
    }

    public void paintPoint(int xCoordinate) {
        nthRow.set(xCoordinate + EXTRA_INDEX, POINT);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String section : nthRow) {
            stringBuilder.append(section);
        }
        return stringBuilder.toString();
    }
}
