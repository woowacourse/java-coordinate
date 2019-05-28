package coordinate.view;

import coordinate.Figure;
import coordinate.domain.Point;

public class OutputView {
    private static final String LINES = "----";
    private static final String VERTICAL_BAR = "|";
    private static final String FORMAT_NUMBER = "3";
    private static final String STAR = "* ";

    private static final int MAX_POINT = Point.MAX_POINT;
    private static final int MIN_POINT = Point.MIN_POINT;

    private OutputView() {
    }

    public static void showGraph(final Figure figure) {
        showHorizontalLines(figure);

        showLInes();
        showBottomNumbers();
    }

    private static void showHorizontalLines(Figure figure) {
        for (int row = MAX_POINT; row >= MIN_POINT; row--) {
            System.out.print(String.format("%" + FORMAT_NUMBER + "s", row));
            System.out.print(VERTICAL_BAR);
            showHorizontalOneLine(figure, row);
            System.out.println();
        }
    }

    private static void showHorizontalOneLine(Figure figure, int row) {
        for (int col = MIN_POINT; col <= MAX_POINT; col++) {
            showPoint(figure, row, col);
        }
    }

    private static void showPoint(Figure figure, int row, int col) {
        if (figure.hasPoint(Point.of(col, row))) {
            System.out.print(String.format("%-" + FORMAT_NUMBER + "s", STAR));
            return;
        }
        System.out.print(String.format("%" + FORMAT_NUMBER + "s", "   "));
    }

    private static void showLInes() {
        for (int col = MIN_POINT; col <= MAX_POINT; col++) {
            System.out.print(LINES);
        }
        System.out.println();
    }

    private static void showBottomNumbers() {
        System.out.print("  ");
        for (int col = MIN_POINT; col <= MAX_POINT; col++) {
            System.out.print(String.format("%" + FORMAT_NUMBER + "s", col));
        }
        System.out.println();
    }

    public static void showArea(final Figure figure) {
        try {
            System.out.println(figure.getName() + "는 "
                    + String.format("%." + FORMAT_NUMBER + "f", figure.getArea()) + "입니다");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
