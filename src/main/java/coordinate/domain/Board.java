package coordinate.domain;

import java.util.ArrayList;
import java.util.List;

public class Board {
    final static int MIN_BOARD_SIZE = 0;
    final static int MAX_BOARD_SIZE = 25;
    private final List<Axis> board;

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

    private List<Axis> initBoard() {
        List<Axis> board = new ArrayList<>();
        for (int positionNo = MIN_BOARD_SIZE; positionNo < MAX_BOARD_SIZE; positionNo++) {
            board.add(Axis.of(MAX_BOARD_SIZE));
        }
        return board;
    }

    void setPoints(Points points) {
        for (int pointIndex = 0; pointIndex < points.size(); pointIndex++) {
            Point point = points.get(pointIndex);
            board.get(point.getY().getNo()).mark(point.getX().getNo());
        }
    }

    public List<Axis> getBoard() {
        return this.board;
    }
}
