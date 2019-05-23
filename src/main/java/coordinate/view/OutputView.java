package coordinate.view;

import coordinate.domain.Figure;
import coordinate.domain.Point;

import java.util.Arrays;

public class OutputView {
    public static void printResult(Figure figure) {
        System.out.println(figure.getResultMessage() + figure.calculateResult());
    }

    public static void printCoordinateSystem(Figure figure) {
        Character[][] coordinate = new Character[24][24];
        for (int i = coordinate.length - 1; i >= 0; i--) {
            Arrays.fill(coordinate[i], ' ');
        }

        for (Point point : figure.getPoints()) {
            coordinate[point.getY() - 1][point.getX() - 1] = '*';
        }

        for (int i = coordinate.length - 1; i >= 0; i--) {
            StringBuilder stringBuilder = new StringBuilder(String.format("%2d", (i + 1)) + "|");
            for (int j = 0; j < coordinate[i].length; j++) {
                stringBuilder.append(" " + coordinate[i][j]);
            }
            System.out.println(stringBuilder);
        }
        System.out.println("  +------------------------------------------------");
        System.out.println(" 0    2   4   6   8   10  12  14  16  18  20  22  24");
    }
}
