package coordinate.domain;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

class LineTest {
    @Test
    void 길이_계산() {
        List<Point> points = Arrays.asList(
                new Point(10, 10),
                new Point(14, 15)
        );
        Line line = new Line(new Points(points));
        assertThat(line.getDistance()).isEqualTo(6.403124, Offset.offset(0.00099));
    }
}