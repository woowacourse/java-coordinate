package coordinate;

import coordinate.domain.Line;
import coordinate.domain.Point;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class LineTest {
    @Test
    void checkSamePointTest() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        assertThrows(IllegalArgumentException.class, () -> new Line(p1, p2));
    }

    @Test
    void calculateDistanceTest() {
        Point p1 = new Point(0, 1);
        Point p2 = new Point(1, 2);
        Line line = new Line(p1, p2);
        assertThat(line.calculateDistance()).isEqualTo(Math.sqrt(2), Offset.offset(0.001));
    }
}