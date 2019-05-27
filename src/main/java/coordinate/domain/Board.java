package coordinate.domain;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final List<List<Boolean>> board;
    final static int MIN_BOARD_SIZE = 0;
    final static int MAX_BOARD_SIZE = 25;

    public Board(Points points) {
        checkValidPoints(points);
        this.board = initBoard();
        setPoints(points);
    }

    private void checkValidPoints(Points points) {
        for (int pointIndex = 0; pointIndex < points.size(); pointIndex++) {
            checkValidPoint(points.get(pointIndex));
        }
    }

    private void checkValidPoint(Point point) {
        if (point.getX().isLessThan(MIN_BOARD_SIZE) || point.getX().isMoreThan(MAX_BOARD_SIZE)) {
            throw new IllegalArgumentException(String.format("X값은 %d ~ %d 입니다", MIN_BOARD_SIZE, MAX_BOARD_SIZE));
        }
        if (point.getY().isLessThan(MIN_BOARD_SIZE) || point.getY().isMoreThan(MAX_BOARD_SIZE)) {
            throw new IllegalArgumentException(String.format("Y값은 %d ~ %d 입니다", MIN_BOARD_SIZE, MAX_BOARD_SIZE));
        }
    }

    private List<List<Boolean>> initBoard() {
        List<List<Boolean>> board = new ArrayList<>();
        for (int axisY = MIN_BOARD_SIZE; axisY < MAX_BOARD_SIZE; axisY++) {
            board.add(new ArrayList<>());
            initAxisX(board, axisY);
        }
        return board;
    }

    private void initAxisX(List<List<Boolean>> board, int axisY) {
        for (int axisX = MIN_BOARD_SIZE; axisX < MAX_BOARD_SIZE; axisX++) {
            board.get(axisY).add(false);
        }
    }

    void setPoints(Points points) {
        for (int pointIndex = 0; pointIndex < points.size(); pointIndex++) {
            Point point = points.get(pointIndex);
            board.get(point.getY().getNo()).set(point.getX().getNo(), true);
        }
    }

    public List<List<Boolean>> getBoard() {
        return this.board;
    }
}
