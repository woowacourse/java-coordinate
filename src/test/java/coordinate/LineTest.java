package coordinate;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class LineTest {
    @Test
    void 두_점은_같을_수_없다() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        assertThrows(IllegalArgumentException.class, () -> new Line(new Points(Arrays.asList(p1, p2))));
    }

    @Test
    void 두_점_사이_거리계산() {
        Point p1 = new Point(0, 1);
        Point p2 = new Point(1, 2);
        Line line = new Line(new Points(Arrays.asList(p1, p2)));
        assertThat(line.calculateDistance()).isEqualTo(Math.sqrt(2), Offset.offset(0.001));
    }
}