package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class BoardTest {
    @Test
    void 보드_유효성_X_예외_테스트() {
        Points points = new Points(Arrays.asList(new Point(-1,3), new Point(3, 5)));

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Board(points);
        }).withMessage(String.format("X값은 %d ~ %d 입니다.", Board.MIN_BOARD_SIZE, Board.MAX_BOARD_SIZE));
    }

    @Test
    void 보드_유효성_Y_예외_테스트() {
        Points points = new Points(Arrays.asList(new Point(0,26), new Point(3, 5)));

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new Board(points);
        }).withMessage(String.format("Y값은 %d ~ %d 입니다.", Board.MIN_BOARD_SIZE, Board.MAX_BOARD_SIZE));
    }
}
