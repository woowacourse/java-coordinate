package coordinate.domain;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {
    @Test
    void 길이_계산() {
        List<Point> points = Arrays.asList(
                new Point(10, 10),
                new Point(14, 15)
        );
        Line line = new Line(points);
        assertThat(line.getDistance()).isEqualTo(6.403124, Offset.offset(0.00099));
    }

    @Test
    void 잘못된_점_입력() {
        List<Point> points = Arrays.asList(
                new Point(10, 10)
        );
        assertThrows(IllegalArgumentException.class, () -> {
            new Line(points);
        });
    }
}