package coordinate.domain;

import coordinate.domain.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointTest {
    @Test
    void equalsTest() {
        assertThat(new Point(0, 0)).isEqualTo(new Point(0, 0));
    }

    @Test
    void xLimitOverTest() {
        assertThrows(IllegalArgumentException.class, () -> new Point(25, 10));
    }

    @Test
    void xLimitUnderTest() {
        assertThrows(IllegalArgumentException.class, () -> new Point(-1, 10));
    }

    @Test
    void yLimitOverTest() {
        assertThrows(IllegalArgumentException.class, () -> new Point(10, 25));
    }

    @Test
    void yLimitUnderTest() {
        assertThrows(IllegalArgumentException.class, () -> new Point(10, -1));
    }

    @Test
    void compareBiggerWhenSameYTest() {
        Point p1 = new Point(1, 0);
        Point p2 = new Point(0, 0);
        assertThat(p1.compareTo(p2)).isEqualTo(1);
    }

    @Test
    void compareBiggerWhenSameXTest() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 0);
        assertThat(p1.compareTo(p2)).isEqualTo(1);
    }

    @Test
    void compareSmallerWhenSameYTest() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 0);
        assertThat(p1.compareTo(p2)).isEqualTo(-1);
    }

    @Test
    void compareSmallerWhenSameXTest() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 1);
        assertThat(p1.compareTo(p2)).isEqualTo(-1);
    }

    @Test
    void compareSameTest() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);
        assertThat(p1.compareTo(p2)).isEqualTo(0);
    }
}
