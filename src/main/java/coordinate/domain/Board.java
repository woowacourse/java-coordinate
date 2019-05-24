package coordinate.domain;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final static int MAX_BOARD_SIZE = 25;
    private final static int MIN_BOARD_SIZE = 0;

    private final List<List<Boolean>> board;

    public Board(Points points) {
        this.board = initBoard();
        setPoints(points);
    }

    private List<List<Boolean>> initBoard() {
        List<List<Boolean>> board = new ArrayList<>();
        for (int axisY = MIN_BOARD_SIZE; axisY < MAX_BOARD_SIZE; axisY++) {
            board.add(new ArrayList<>());
            for (int axisX = MIN_BOARD_SIZE; axisX < MAX_BOARD_SIZE; axisX++) {
                board.get(axisY).add(false);
            }
        }
        return board;
    }

    void setPoints(Points points) {
        for (int pointIndex = 0; pointIndex < points.size(); pointIndex++) {
            Point point = points.get(pointIndex);
            board.get(point.getY()).set(point.getX(), true);
        }
    }

    public List<List<Boolean>> getBoard() {
        return this.board;
    }
}
