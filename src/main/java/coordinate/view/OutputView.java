package coordinate.view;

import coordinate.domain.Figure;
import coordinate.domain.Point;
import coordinate.domain.PointList;


public class OutputView {
    public static void printPoints(PointList pointList) {
        printRows(pointList);
        printZeroPosition(pointList);
        printLastRow(pointList);
        System.out.println();
        printRowNumbers();
        System.out.println();
    }

    private static void printRows(PointList pointList) {
        for (int y = 24; y >= 1; y--) {
            System.out.printf("%2s", isEvenNumber(y));
            printRow(pointList, y);
            System.out.println();
        }
    }

    private static void printRow(PointList pointList, int y) {
        for (int x = 0; x <= 24; x++) {
            printRowPart(pointList, y, x);
        }
    }

    private static void printRowNumbers() {
        System.out.printf("%2s", 0);
        for (int i = 2; i <= 24; i += 2) {
            System.out.printf("%4s", i);
        }
    }

    private static void printLastRow(PointList pointList) {
        for (int i = 1; i <= 24; i++) {
            printLastRowPart(pointList, i);
        }
    }

    private static void printLastRowPart(PointList pointList, int i) {
        if (pointList.isContain(new Point("" + i, "0"))) {
            System.out.print(" * ");
            return;
        }
        System.out.print("ㅡ");
    }

    private static void printRowPart(PointList pointList, int y, int x) {
        if (pointList.isContain(new Point("" + x, "" + y))) {
            System.out.print("*");
            return;
        }
        if (x == 0) {
            System.out.print("|");
            return;
        }
        System.out.printf("%2s", " ");

    }

    private static void printZeroPosition(PointList pointList) {
        if (pointList.isContain(new Point("0", "0"))) {
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
        System.out.printf(figure.findResult(), figure.findArea());
    }
}
