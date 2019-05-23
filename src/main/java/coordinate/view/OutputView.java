package coordinate.view;

import coordinate.domain.Figure;
import coordinate.domain.Point;
import coordinate.domain.Points;

//(10,10)-(22,10)-(22,18)-(10,18)
public class OutputView {
    public static void printCoordinate(Points points) {
        boolean[][] coorinates = new boolean[25][25];
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 25; j++) {
                coorinates[i][j] = false;
            }
        }
        for (Point point : points.getPoints()) {
            coorinates[point.getY()][point.getX()] = true;
        }
        for (int i = 24; i >= 0; i--) {
            if (i % 2 == 0) {
                System.out.printf("%3s", i + "|");
            } else {
                System.out.printf("%3s", "|");
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 25; j++) {
                if (coorinates[i][j]) {
                    sb.append(" . ");
                    continue;
                }
                sb.append("   ");
            }
            System.out.println(sb.toString());
        }

        for (int i = 0; i < 24; i++) {
            if (i == 0) {
                System.out.printf("%3s", "+");
            }
            System.out.print("---");
        }
        System.out.println();
        System.out.println("0     2      4     6      8     10    12    14    16    18    20    22    24");
    }

    public static void printArea(Figure figure) {
        System.out.println(figure);
    }
}
