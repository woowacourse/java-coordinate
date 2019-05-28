package coordinatecalculator.domain;

import coordinatecalculator.view.inputview.PointParser;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PointTest {

    @Test
    void 좌표_입력범위() {
        assertThrows(IllegalArgumentException.class, () -> {
            Point.of(-1, 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Point.of(0, -1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Point.of(25, 0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Point.of(0, 25);
        });
    }

    @Test
    void 길이() {
        assertThat(PointGroupTest.one_one.getDistance(PointGroupTest.zero_zero))
                .isEqualTo(1.414, offset(0.001));
    }

    @Test
    void 각도() {
        double angle = PointGroupTest.one_zero.getAngle(PointGroupTest.zero_zero, PointGroupTest.zero_one);
        assertThat(angle).isEqualTo(90, offset(0.001));
    }
}