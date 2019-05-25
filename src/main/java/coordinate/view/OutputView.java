package coordinate.view;

import coordinate.domain.Figure;
import coordinate.domain.Point;

import java.util.Arrays;

public class OutputView {
    private static final String NEWLINE = System.getProperty("line.separator");
    private static final char WHITE_SPACE = ' ';
    private static final char POINT = '*';
    private static final String Y_AXIS_NUMBER_FORMAT = "%2d";
    private static final char Y_AXIS = '|';

    public static void printResult(Figure figure) {
        System.out.println(figure.getResultMessage() + figure.calculateResult());
    }

    public static void printCoordinateSystem(Figure figure) {
        print(setUpCoordinate(figure));
    }

    private static Character[][] setUpCoordinate(Figure figure) {
        Character[][] coordinate = new Character[25][25];
        for (int i = coordinate.length - 1; i >= 1; i--) {
            Arrays.fill(coordinate[i], WHITE_SPACE);
        }
        for (Point point : figure.getPoints()) {
            coordinate[point.getY()][point.getX()] = POINT;
        }
        return coordinate;
    }

    private static void print(Character[][] coordinate) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = coordinate.length - 1; i >= 1; i--) {
            stringBuilder.append(String.format(Y_AXIS_NUMBER_FORMAT, (i))).append(Y_AXIS);
            for (int j = 1; j < coordinate[i].length; j++) {
                stringBuilder.append(WHITE_SPACE).append(coordinate[i][j]);
            }
            stringBuilder.append(NEWLINE);
        }
        System.out.print(stringBuilder);
        System.out.println("  +------------------------------------------------");
        System.out.println(" 0    2   4   6   8   10  12  14  16  18  20  22  24");
    }
}
