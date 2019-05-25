package coordinatecalculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Drawer {
    private static final int COORDINATE_UPPER_BOUND = 24;
    private static final int COORDINATE_LOWER_BOUND = 0;
    private static final int COORDINATE_X_OFFSET = 2;
    private static final int COORDINATE_Y_OFFSET = 2;

    private final List<StringBuilder> board = new ArrayList<>();

    private Drawer(Points points) {
        makePicture(points);
    }

    public static Drawer newInstance(Points points) {
        return new Drawer(points);
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
            board.get(COORDINATE_UPPER_BOUND - point.getY()).replace(point.getX() * COORDINATE_Y_OFFSET + COORDINATE_X_OFFSET, point.getX() * COORDINATE_Y_OFFSET + COORDINATE_X_OFFSET + 1, "*");
        }
    }

    public List<StringBuilder> getBoard() {
        return board;
    }

}
