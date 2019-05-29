package coordinate.domain;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public final static int MAX_BOARD_SIZE = 25;
    private final static int MIN_BOARD_SIZE = 0;

    private final List<BoardSingleLine> board;

    public Board(Points points) {
        this.board = initBoard();
        setPoints(points);
    }

    private static List<BoardSingleLine> initBoard() {
        List<BoardSingleLine> board = new ArrayList<>();
        for (int i = MIN_BOARD_SIZE; i < MAX_BOARD_SIZE; i++) {
            board.add(new BoardSingleLine());
        }
        return board;
    }

    private void setPoints(Points points) {
        for (int pointIndex = 0; pointIndex < points.size(); pointIndex++) {
            Point point = points.get(pointIndex);
            board.get(point.getY()).pointing(point.getX());
        }
    }

    public BoardSingleLine getBoardSingleLine(int indexY) {
        return this.board.get(indexY);
    }
}
