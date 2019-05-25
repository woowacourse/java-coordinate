package coordinatecalculator.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PointTest {
    static Point zero_zero = Point.of(0, 0);
    static Point zero_one = Point.of(0, 1);
    static Point one_zero = Point.of(1, 0);
    static Point one_one = Point.of(1, 1);
    static List<Point> answer1 = Arrays.asList(zero_zero, zero_one, one_zero, one_one);

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
        assertThat(one_one.getDistance(zero_zero)).isEqualTo(1.414, offset(0.001));
    }
}