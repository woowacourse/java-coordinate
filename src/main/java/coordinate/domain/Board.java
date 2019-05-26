package coordinate.domain;

import java.util.*;

public class Board {
    private final static int MAX_BOARD_SIZE = 25;
    private final static int MIN_BOARD_SIZE = 0;

    private final List<List<Boolean>> board;

    public Board(Points points) {
        this.board = initBoard();
        setPoints(points);
    }

    private static List<List<Boolean>> initBoard() {
        List<List<Boolean>> board = new ArrayList<>();
        for (int i = MIN_BOARD_SIZE; i < MAX_BOARD_SIZE; i++) {
            board.add(initBoardOfSingleLine());
        }
        return board;
    }

    private static List<Boolean> initBoardOfSingleLine() {
        return new ArrayList<>(Collections.nCopies(MAX_BOARD_SIZE, Boolean.FALSE));
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
