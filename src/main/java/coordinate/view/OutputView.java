package coordinate.view;

import coordinate.domain.Board;
import coordinate.domain.Shape;

import java.util.List;

public class OutputView {
    private final static int MAX_BOARD_SIZE = 25;
    private final static int MIN_BOARD_SIZE = 0;
    private final static String POINT = "●";

    public static void printResult(Shape shape) {
        //TODO
        // 삼각형,사각형, 길이 또는 면적 넓이 출력
        System.out.println(shape.toString());
    }

    public static void printBoard(Board boardVo) {
        List<List<Boolean>> board = boardVo.getBoard();
        StringBuilder sb = new StringBuilder();
        for (int axisY = MAX_BOARD_SIZE-1; axisY > MIN_BOARD_SIZE; axisY--) {
            for (int axisX = MIN_BOARD_SIZE; axisX < MAX_BOARD_SIZE; axisX++) {
                boolean pointState = board.get(axisY).get(axisX);
                if (axisX == MIN_BOARD_SIZE && !pointState) {
                    sb.append(String.format("%5.5s|", axisY));
                    continue;
                }
                if (pointState) {
                    sb.append(String.format("%5.5s", POINT));
                    continue;
                }
                sb.append(String.format("%5.5s", ""));
            }
            sb.append(String.format("\n%5.5s|\n", ""));
        }

        for (int axisX = MIN_BOARD_SIZE; axisX < MAX_BOARD_SIZE; axisX++) {
            boolean pointState = board.get(0).get(axisX);
            if (axisX == MIN_BOARD_SIZE && !pointState) {
                sb.append(String.format("%5.5s+", ""));
                continue;
            }
            if (pointState) {
                sb.append(String.format("%5.5s",  "----"+ POINT));
                continue;
            }
            sb.append(String.format("%5.5s", "-----"));
        }
        sb.append("\n ");
        for (int axisX = MIN_BOARD_SIZE; axisX < MAX_BOARD_SIZE; axisX+=2) {
            sb.append(String.format("%5.5s", axisX));
            sb.append(String.format("%5.5s", ""));
        }
        sb.toString();
    }
}
