package coordinate.view;

import coordinate.domain.Axis;
import coordinate.domain.Board;
import coordinate.domain.Shape;

import java.util.List;

public class OutputView {
    private final static int MAX_BOARD_SIZE = 25;
    private final static int MIN_BOARD_SIZE = 0;
    private final static String POINT = "●";

    public static void printResult(Shape shape) {
        System.out.println(String.format("%s의 %s는 %.1f", shape.getName(), shape.getOperationName(), shape.calculateFigure()));
    }

    public static void printBoard(Board board) {
        System.out.println(buildBoard(board));
    }

    public static String buildBoard(Board boardVo) {
        List<Axis> board = boardVo.getBoard();
        StringBuilder sb = new StringBuilder();
        buildAxisY(board, sb);
        buildAxisX(board, sb);
        return sb.toString();
    }

    private static void buildAxisX(List<Axis> board, StringBuilder sb) {
        sb.append(String.format("%6.6s", ""));
        if (board.get(0).isMarked(0)) {
            sb.append(POINT);
        }
        if (!board.get(0).isMarked(0)) {
            sb.append("+");
        }
        for (int axisX = MIN_BOARD_SIZE + 1; axisX < MAX_BOARD_SIZE; axisX++) {
            boolean pointState = board.get(0).isMarked(axisX);
            if (pointState) {
                sb.append(String.format("%5.5s%s", "-----", POINT));
                continue;
            }
            sb.append(String.format("%6.6s", "-------"));
        }
        sb.append("\n ");
        for (int axisX = MIN_BOARD_SIZE; axisX < MAX_BOARD_SIZE; axisX += 2) {
            sb.append(String.format("%6.6s", axisX));
            sb.append(String.format("%6.6s", ""));
        }
    }

    private static void buildAxisY(List<Axis> board, StringBuilder sb) {
        for (int axisY = MAX_BOARD_SIZE - 1; axisY > MIN_BOARD_SIZE; axisY--) {
            for (int axisX = MIN_BOARD_SIZE; axisX < MAX_BOARD_SIZE; axisX++) {
                boolean pointState = board.get(axisY).isMarked(axisX);
                if (axisX == MIN_BOARD_SIZE && !pointState) {
                    sb.append(String.format("%6.6s|", axisY));
                    continue;
                }
                if (pointState) {
                    sb.append(String.format("%6.6s", POINT));
                    continue;
                }
                sb.append(String.format("%6.6s", ""));
            }
            sb.append(String.format("\n%6.6s|\n", ""));
        }
    }
}
