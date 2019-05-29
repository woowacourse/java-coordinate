package coordinatecalculator.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Drawer {
    private static final int EVEN_NUMBER = 0;
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
            board.add(new StringBuilder((i % 2 == EVEN_NUMBER) ? String.format("%2d", i) : "  ").
                    append("|                                                "));
        }
        board.add(new StringBuilder("  +------------------------------------------------"));
        board.add(new StringBuilder(" 0    2   4   6   8   10  12  14  16  18  20  22  24 "));

        plotPoint(points);
    }

    private void plotPoint(Points points) {
        List<Point> sortedPoints = Collections.unmodifiableList(points.getSortedPoints());

        for (Point point : sortedPoints) {
            board.get(Y_TOP_POSITION - point.getY())
                    .replace((point.getAxisValue() * X_DOUBLE_POSITION) + X_PARALLEL_TRANSLATION, (point.getAxisValue() * X_DOUBLE_POSITION) + X_PARALLEL_TRANSLATION + 1, "*");
        }
    }

    public List<StringBuilder> getBoard() {
        return board;
    }

}
