package coordinatecalculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Drawer {
    private static final int COORDINATE_UPPER_BOUND = 24;
    private static final int COORDINATE_LOWER_BOUND = 0;
    private static final int COORDINATE_X_OFFSET = 2;
    private static final int COORDINATE_Y_OFFSET = 2;

    private final List<StringBuilder> board = new ArrayList<>();

    public Drawer(Points points) {
        makePicture(points);
    }

    private void makePicture(Points points) {
        makeYAxis();
        makeXAxis();
        makeXNumber();
        plotPoint(points);
    }

    private void makeYAxis() {
        for (int i = COORDINATE_UPPER_BOUND; i > COORDINATE_LOWER_BOUND; i--) {
            board.add(new StringBuilder((i % 2 == 0) ? String.format("%2d", i) : "  ").
                    append("|                                                \n"));
        }
    }

    private void makeXAxis() {
        StringBuilder stringBuilder = new StringBuilder("  +");
        for (int i = COORDINATE_UPPER_BOUND; i > COORDINATE_LOWER_BOUND; i--) {
            stringBuilder.append("--");
        }
        board.add(stringBuilder.append("\n"));
    }

    private void makeXNumber() {
        StringBuilder stringBuilder = new StringBuilder(" 0 ");
        for (int i = COORDINATE_LOWER_BOUND + 1; i <= COORDINATE_UPPER_BOUND; i++) {
            stringBuilder.append((i % 2 == 0) ? String.format("%2d", i) : "  ");
        }
        board.add(stringBuilder.append("\n"));
    }

    private void plotPoint(Points points) {
        List<Point> sortedPoints = points.getSortedPoints();
        for (Point point : sortedPoints) {
            int xIndex = point.getX() * COORDINATE_Y_OFFSET + COORDINATE_X_OFFSET;
            int yIndex = COORDINATE_UPPER_BOUND - point.getY();
            board.get(yIndex).replace(xIndex, xIndex + 1, "*");
        }
    }

    public List<StringBuilder> getBoard() {
        return board;
    }

}
