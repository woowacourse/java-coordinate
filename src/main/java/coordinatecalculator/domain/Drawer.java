package coordinatecalculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Drawer {
    private final List<StringBuilder> board = new ArrayList<>();

    private Drawer(Points points) {
        makePicture(points);
    }

    public static Drawer newInstance(Points points) {
        return new Drawer(points);
    }

    private void makePicture(Points points) {
        for (int i = 24; i > 0; i--) {
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
            board.get(24 - point.getY()).replace(point.getX() * 2 + 2, point.getX() * 2 + 3, "*");
        }
    }

    public List<StringBuilder> getBoard() {
        return board;
    }

}
