package coordinatecalculator.view.outputview;

import coordinatecalculator.domain.Figure;
import coordinatecalculator.domain.Point;

public class ConsoleUI {
    private static StringBuilder stringBuilder;
    private static Figure figure;

    static void printConsoleUI(Figure figure) {
        ConsoleUI.figure = figure;
        drawConsoleUI();
        System.out.println(stringBuilder.toString());
    }

    private static void drawConsoleUI() {
        stringBuilder = new StringBuilder();
        moveY();
    }

    private static void moveY() {
        for (int yCoordinate = 24; yCoordinate > 0; yCoordinate--) {
            stringBuilder.append(drawAxisY(yCoordinate));
            moveX(yCoordinate);
            stringBuilder.append("\n");
        }
        moveAxisX();
    }

    private static String drawAxisY(int lineNum) {
        if (lineNum % 2 == 0) {
            return String.format("%2d", lineNum);
        }
        return "  ";
    }

    private static void moveX(int yCoordinate) {
        for (int xCoordinate = 0; xCoordinate <= 24; xCoordinate++) {
            stringBuilder.append(getDrawnPoint(xCoordinate, yCoordinate));
        }
    }

    private static String getDrawnPoint(final int xCoordinate, final int yCoordinate) {
        if (xCoordinate == 0) {
            return drawPointAtXZero(yCoordinate);
        }
        return drawPoint(xCoordinate, yCoordinate);
    }

    private static String drawPointAtXZero(final int yCoordinate) {
        if (isContainsPoint(0, yCoordinate)) {
            return "•";
        }
        return "|";
    }

    private static boolean isContainsPoint(final int xCoordinate, final int yCoordinate) {
        return figure.getPoints().contains(Point.of(xCoordinate, yCoordinate));
    }

    private static String drawPoint(int xCoordinate, int yCoordinate) {
        if (isContainsPoint(xCoordinate, yCoordinate)) {
            return String.format("%2s", "•");
        }
        return "  ";
    }

    private static void moveAxisX() {
        stringBuilder.append("  ");
        stringBuilder.append(drawOrigin());
        for (int xCoordinate = 1; xCoordinate <= 24; xCoordinate++) {
            stringBuilder.append(drawAxisX(xCoordinate));
        }
        stringBuilder.append("\n");
        moveAxisXNum();
    }

    private static String drawOrigin() {
        if (isContainsPoint(0, 0)) {
            return "•";
        }
        return "+";
    }

    private static String drawAxisX(final int xCoordinate) {
        if (isContainsPoint(xCoordinate, 0)) {
            return "-•";
        }
        return "--";
    }

    private static void moveAxisXNum() {
        stringBuilder.append(" 0 ");
        for (int xCoordinate = 1; xCoordinate <= 24; xCoordinate++) {
            stringBuilder.append(drawAxisXNum(xCoordinate));
        }
        stringBuilder.append("\n");
    }

    private static String drawAxisXNum(final int xCoordinate) {
        if (xCoordinate % 2 == 0) {
            return String.format("%2d", xCoordinate);
        }
        return "  ";
    }

}
