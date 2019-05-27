package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineTest {

    @Test
    public void 두_점_사이의_거리를_제대로_출력해주는지_테스트() {
        List<Point> points = Arrays.asList(
                new Point(10, 10),
                new Point(14, 15)
        );

        Shape line = new Line(points);
        assertThat(line.area()).isEqualTo(6.403124, offset(0.00099));
    }

    @Test
    public void 두_점이_같은_위치일_때_예외처리_테스트() {
        List<Point> points = Arrays.asList(
                new Point(10, 10),
                new Point(10, 10)
        );

        assertThrows(IllegalArgumentException.class, () -> {
            new Line(points);
        });
    }
}
