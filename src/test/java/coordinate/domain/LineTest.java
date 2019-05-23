package coordinate.domain;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class LineTest {
    @Test
    void nullPointTest() {
        assertThrows(IllegalArgumentException.class, () -> new Line(null, null));
    }

    @Test
    void checkSamePointTest() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        assertThrows(IllegalArgumentException.class, () -> new Line(p1, p2));
    }

    @Test
    void 점들의_값은_같고_순서만_바뀐_라인들은_같다() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        Line l1 = new Line(p1, p2);
        Line l2 = new Line(p2, p1);
        assertThat(l1.equals(l2)).isTrue();
    }

    @Test
    void calculateDistanceTest() {
        Point p1 = new Point(0, 1);
        Point p2 = new Point(1, 2);
        Line line = new Line(p1, p2);
        assertThat(line.length()).isEqualTo(Math.sqrt(2), Offset.offset(0.001));
    }

    @Test
    void calculateSlopeTest() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        Line line = new Line(p1, p2);
        assertThat(line.calculateSlope()).isEqualTo(1.0, Offset.offset(0.001));
    }

    @Test
    void isHorizontalTest() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(5, 0);
        Line line = new Line(p1, p2);
        assertThat(line.isHorizontal()).isTrue();
    }

    @Test
    void isVerticalTest() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 5);
        Line line = new Line(p1, p2);
        assertThat(line.isVertical()).isTrue();
    }
}