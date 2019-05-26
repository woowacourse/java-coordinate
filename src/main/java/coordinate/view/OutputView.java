package coordinate.view;

import coordinate.domain.Figure;
import coordinate.domain.Point;
import coordinate.domain.Points;


public class OutputView {
    public static void printPoints(Points points) {
        printRows(points);
        printZeroPosition(points);
        printLastRow(points);
        System.out.println();
        printRowNumbers();
        System.out.println();
    }

    private static void printRows(Points points) {
        for (int y = 24; y >= 1; y--) {
            System.out.printf("%2s", isEvenNumber(y));
            printRow(points, y);
            System.out.println();
        }
    }

    private static void printRow(Points points, int y) {
        for (int x = 0; x <= 24; x++) {
            printRowPart(points, y, x);
        }
    }

    private static void printRowNumbers() {
        System.out.printf("%2s", 0);
        for (int i = 2; i <= 24; i += 2) {
            System.out.printf("%4s", i);
        }
    }

    private static void printLastRow(Points points) {
        for (int i = 1; i <= 24; i++) {
            printLastRowPart(points, i);
        }
    }

    private static void printLastRowPart(Points points, int i) {
        if (points.isContain(new Point(i, 0))) {
            System.out.print(" * ");
            return;
        }
        System.out.print("ㅡ");
    }

    private static void printRowPart(Points points, int y, int x) {
        if (points.isContain(new Point(x,  y))) {
            System.out.print("*");
            return;
        }
        if (x == 0) {
            System.out.print("|");
            return;
        }
        System.out.printf("%2s", " ");

    }

    private static void printZeroPosition(Points points) {
        if (points.isContain(new Point(0, 0))) {
            System.out.print("  *");
            return;
        }
        System.out.print("  +");
    }

    private static String isEvenNumber(int index) {
        if (index % 2 == 0) {
            return "" + index;
        }
        return "";
    }

    public static void printResult(Figure figure) {
        System.out.printf(figure.getResult(), figure.calculateArea());
    }
}
