package coordinate.domain;

import java.util.*;

public class Board {
    private final static int MAX_BOARD_SIZE = 25;
    private final static int MIN_BOARD_SIZE = 0;

    private final List<List<Boolean>> board;

    public Board(Points points) {
        this.board = initBoardAxisY();
        setPoints(points);
    }

    private List<List<Boolean>> initBoardAxisY() { //TODO 보드 초기화하기
        List<List<Boolean>> board = new ArrayList<>();
        for (int axisY = MIN_BOARD_SIZE; axisY < MAX_BOARD_SIZE; axisY++) {
            board.add(initBoardAxisX());
        }
        return board;
    }

    public static List<Boolean> initBoardAxisX() { //TODO #보드 초기화하기 : List초기화하는 방법??
        List<Boolean> oneLineOfBoard = new ArrayList<>(MAX_BOARD_SIZE);
        for (int i = MIN_BOARD_SIZE; i < MAX_BOARD_SIZE; i++) {
            oneLineOfBoard.add(false);
        }
        return oneLineOfBoard;
    }

    private void setPoints(Points points) {
        for (int pointIndex = 0; pointIndex < points.size(); pointIndex++) {
            Point point = points.get(pointIndex);
            board.get(point.getY()).set(point.getX(), true);
        }
    }

    public List<List<Boolean>> getBoard() {
        return this.board;
    }
}
