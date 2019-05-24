package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {
    @Test
    void 보드_생성하는_테스트() {
        Board board = new Board(new Points(Arrays.asList(new Point(1, 2), new Point(3, 4), new Point(0, 0), new Point(0, 10), new Point(10, 0))));
        System.out.println(board.toString());
//        assertThat(board).isEqualTo(new Board(new Points(Arrays.asList(new Point(1, 2), new Point(3, 4)))));
    }
}
