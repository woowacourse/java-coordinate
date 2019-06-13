package coordinate.view.output;

import coordinate.domain.figure.Figure;
import coordinate.domain.point.Point;
import coordinate.util.CalculateMsgType;

public class OutputView {
    private static final String AXIS = "|";
    private static final String HORIZON = "ㅡ";
    private static final String BLANK = " ";
    private static final String EMPTY = "";
    private static final String POINT = "*";
    private static final String ONE_SPACE = "%s";
    private static final String TWO_SPACE = "%2s";
    private static final String THREE_SPACE = "%3s";

    public static void outputArea(Figure figure) {
        System.out.println(CalculateMsgType.messageOf(figure) + figure.area());
    }

    public static void outputCoordinate(Figure figure) {
        printAxis(figure);
        printHorizontal();
        blankLine();
    }

    private static void printAxis(Figure figure) {
        for (int i = Point.MAX_Y_VALUE; i >= Point.MIN_Y_VALUE; i--) {
            printf(TWO_SPACE, printEvenNumber(i));
            printf(ONE_SPACE, AXIS);
            printPoint(figure, i);
            blankLine();
        }
    }

    private static void printPoint(Figure figure, int i) {
        for (int j = Point.MIN_X_VALUE; j <= Point.MAX_X_VALUE; j++) {
            printf(TWO_SPACE, checkPoint(figure, i, j));
        }
    }

    private static String checkPoint(Figure figure, int i, int j) {
        if (figure.contain(new Point(j, i))) {
            return POINT;
        }
        return BLANK;
    }

    private static void printHorizontal() {
        printf(THREE_SPACE, BLANK);
        for (int i = Point.MIN_X_VALUE; i <= Point.MAX_X_VALUE; i++) {
            printf(ONE_SPACE, HORIZON);
        }
        blankLine();
        printf(TWO_SPACE, BLANK);
        for (int i = Point.MIN_X_VALUE; i <= Point.MAX_X_VALUE; i++) {
            printf(TWO_SPACE, printEvenNumber(i));
        }
    }

    private static String printEvenNumber(int i) {
        if (i % 2 == 0) {
            return String.valueOf(i);
        }
        return EMPTY;
    }

    private static void printf(String s, String text) {
        System.out.printf(s, text);
    }

    private static void blankLine() {
        System.out.println();
    }
}
