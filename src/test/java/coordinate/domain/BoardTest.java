package coordinate.domain;

import coordinate.view.OutputView;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BoardTest {
    @Test
    void 보드_생성하는_테스트() {
        Board board = new Board(new Points(Arrays.asList(new Point(1, 2), new Point(3, 4), new Point(5, 4), new Point(0, 10), new Point(10, 0))));
        OutputView.printBoard(board);
    }
}
