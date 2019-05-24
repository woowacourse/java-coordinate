package coordinatecalculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Drawer {
    private static final int Y_TOP_POSITION = 24;
    private static final int X_DOUBLE_POSITION = 2;
    private static final int X_PARALLEL_TRANSLATION = 2;

    private final List<StringBuilder> board = new ArrayList<>();

    private Drawer(Points points) {
        makePicture(points);
    }

    public static Drawer newInstance(Points points) {
        return new Drawer(points);
    }

    private void makePicture(Points points) {
        for (int i = Y_TOP_POSITION; i > 0; i--) {
            board.add(new StringBuilder((i % 2 == 0) ? String.format("%2d" ,i) : "  ").
                    append("|                                                \n"));
        }
        board.add(new StringBuilder("  +------------------------------------------------\n"));
        board.add(new StringBuilder(" 0    2   4   6   8   10  12  14  16  18  20  22  24 \n"));

        plotPoint(points);
    }

    private void plotPoint(Points points) {
        List<Point> sortedPoints = points.getSortedPoints();

        for (Point point : sortedPoints) {
            board.get(Y_TOP_POSITION - point.getY())
                    .replace((point.getX() * X_DOUBLE_POSITION) + X_PARALLEL_TRANSLATION, (point.getX() * X_DOUBLE_POSITION) + X_PARALLEL_TRANSLATION + 1, "*");
        }
    }

    public List<StringBuilder> getBoard() {
        return board;
    }

}
