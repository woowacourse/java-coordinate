package coordinatecalculator.view;

import coordinatecalculator.domain.Coordinate;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void printScore(String message) {
        System.out.println(message);
    }

    public static void printErrorMessage(String errorMessage) {
        System.err.println(errorMessage);
    }

    public static void printBoardLine(List<Coordinate> coordinates) {
        yAxis(coordinates);
        printLine();
        xAxis();

    }

    private static void printLine() {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder("  +");
        for (int i = 1; i < 24; i++) {
            stringBuilder.append("──");
        }
        stringBuilder.append("─");
        System.out.println(stringBuilder.toString());
    }

    private static void xAxis() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= 24; i++) {
            stringBuilder.append(printNumber(i));
        }
        System.out.println(stringBuilder.toString());
    }

    private static String printNumber(int i) {
        return (i % 2 == 0) ? String.format("%2d", i) : "  ";
    }

    private static void yAxis(List<Coordinate> coordinates) {
        for (int i = 24; i > 0; i--) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(printNumber(i))
                    .append("|");

            makeBlank(stringBuilder);

            printCoordinate(coordinates, i, stringBuilder);
            System.out.println(stringBuilder.toString());

        }
    }

    private static void printCoordinate(List<Coordinate> coordinates, int i, StringBuilder stringBuilder) {
        coordinates.stream()
                .filter(coordinate -> coordinate.getY() == i)
                .collect(Collectors.toList())
                .forEach(coordinate -> stringBuilder.replace(coordinate.getX() * 2 + 1, coordinate.getX() * 2 + 1, "*"));
    }

    private static void makeBlank(StringBuilder stringBuilder) {
        for (int a = 0; a < 24; a++) {
            stringBuilder.append("  ");
        }
    }

}
