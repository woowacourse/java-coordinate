package coordinate.view;

import coordinate.domain.Board;
import coordinate.domain.Shape;

import java.util.List;

public class OutputView {
    private final static int MAX_BOARD_SIZE = 25;
    private final static int MIN_BOARD_SIZE = 0;
    private final static String POINT = "●";

    public static void printResult(Shape shape) {
        System.out.println(shape.toString() + shape.calculateFigure());
    }

    public static void printBoard(Board boardVo) {
        List<List<Boolean>> board = boardVo.getBoard();
        StringBuilder stringBuilder = new StringBuilder();
        for (int axisY = MAX_BOARD_SIZE - 1; axisY > MIN_BOARD_SIZE; axisY--) {
            stringBuilder.append(pointingAxisX(board, axisY));
            stringBuilder.append(String.format("\n%5.5s|\n", ""));
        }
        for (int axisX = MIN_BOARD_SIZE; axisX < MAX_BOARD_SIZE; axisX++) {
            boolean pointState = board.get(0).get(axisX);
            stringBuilder.append(pointCoordinateX(axisX, pointState));
        }
        stringBuilder.append(numberOfAxisX());
        System.out.println(stringBuilder);
    }

    private static String pointingAxisX(List<List<Boolean>> board, int axisY) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int axisX = MIN_BOARD_SIZE; axisX < MAX_BOARD_SIZE; axisX++) {
            boolean pointState = board.get(axisY).get(axisX);
            stringBuilder.append(pointCoordinate(axisX, axisY, pointState));
        }
        return stringBuilder.toString();
    }

    private static String pointCoordinate(int axisX, int axisY, boolean pointState) {
        if (axisX == MIN_BOARD_SIZE && !pointState) {
            return String.format("%5.5s|", axisY);
        }
        if (axisX == MIN_BOARD_SIZE && pointState) {
            return String.format("%5.5s", axisY + POINT);
        }
        if (pointState) {
            return String.format("%5.5s", POINT);
        }
        return String.format("%5.5s", "");
    }

    private static String pointCoordinateX(int axisX, boolean pointState) {
        if (axisX == MIN_BOARD_SIZE && !pointState) {
            return String.format("%5.5s+", "");
        }
        if (pointState) {
            return String.format("%5.5s", "---" + POINT + "-");
        }
        return String.format("%5.5s", "-----");
    }

    private static String numberOfAxisX() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n ");
        for (int axisX = MIN_BOARD_SIZE; axisX < MAX_BOARD_SIZE; axisX += 2) {
            stringBuilder.append(String.format("%5.5s", axisX));
            stringBuilder.append(String.format("%5.5s", ""));
        }
        return stringBuilder.toString();
    }
}
