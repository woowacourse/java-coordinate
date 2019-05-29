package coordinate.view;

import java.util.ArrayList;
import java.util.List;

import static coordinate.view.UserInterface.MAX_INDEX;
import static coordinate.view.UserInterface.MIN_INDEX;

public class Board {
    private final List<Row> board;

    public Board() {
        List<Row> board = new ArrayList<>();
        for (int i = MIN_INDEX; i < MAX_INDEX; i++) {
            board.add(new Row());
        }
        this.board = board;
    }

    void markPoint(int x, int y) {
        board.get(y).placePoint(x);
    }

    public Row getRow(int y) {
        return board.get(y);
    }
}
