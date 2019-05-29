package coordinate.view;

import coordinate.domain.Board;
import coordinate.domain.Shape;

import java.util.List;

public class OutputView {
    private static final String CENTER = String.format("%2s", "+");
    private static final String AXIS_X_LINE = String.format("%2s", "---");
    private static final String AXIS_Y_LINE = String.format("%2s", "|");
    private static final String POINT = String.format("%2s", "●");
    private static final String BLANK = String.format("%2s", "  ");
    private static final String NEW_LINE = "\n";
    private final static int MAX_BOARD_SIZE = 25;
    private final static int MIN_BOARD_SIZE = 0;

    public static void printResult(Shape shape) {
        System.out.println(shape.toString() + shape.calculateFigure());
    }

    public static void printBoard(Board board) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int axisY = MAX_BOARD_SIZE - 1; axisY > MIN_BOARD_SIZE; axisY--) {
            List<Boolean> boardLine = board.getBoardSingleLine(axisY).getLine();
            stringBuilder.append(drawAxisXOfAxisY(boardLine, axisY));
        }
        stringBuilder.append(drawOnlyAxisX(board));
        System.out.println(stringBuilder);
    }

    private static String drawAxisXOfAxisY(List<Boolean> line, int index) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(isEvenIndex(index) ? String.format("%2s", index) : BLANK);
        stringBuilder.append(line.get(0) ? POINT : AXIS_Y_LINE);
        for (int i = 1; i < line.size(); i++) {
            boolean boardState = line.get(i);
            stringBuilder.append(boardState ? POINT : BLANK);
        }
        stringBuilder.append(NEW_LINE);
        return stringBuilder.toString();
    }

    private static boolean isEvenIndex(int index) {
        return index % 2 == 0;
    }

    private static String drawOnlyAxisX(Board board) {
        List<Boolean> line = board.getBoardSingleLine(0).getLine();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(line.get(0) ? BLANK + POINT : BLANK + CENTER);
        for (int i = 1; i < line.size(); i++) {
            boolean boardState = line.get(i);
            stringBuilder.append(boardState ? POINT : AXIS_X_LINE);
        }
        stringBuilder.append(numberOfAxisX());
        return stringBuilder.toString();
    }

    private static String numberOfAxisX() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(NEW_LINE);
        for (int axisX = MIN_BOARD_SIZE; axisX < MAX_BOARD_SIZE; axisX += 2) {
            stringBuilder.append(String.format("%3s", axisX));
            stringBuilder.append(String.format("%3s", ""));
        }
        return stringBuilder.toString();
    }
}
