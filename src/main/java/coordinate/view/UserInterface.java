package coordinate.view;

import coordinate.domain.Point;
import coordinate.domain.Points;

public class UserInterface {
    static final int MIN_INDEX = 0;
    static final int MAX_INDEX = 25;
    private final Board board;

    UserInterface() {
        this.board = new Board();
    }

    void drawPoints(Points points) {
        for (int i = 0; i < points.size(); i++) {
            Point point = points.get(i);
            board.markPoint(point.getX(), point.getY());
        }
    }

    public Board getBoard() {
        return board;
    }
}
