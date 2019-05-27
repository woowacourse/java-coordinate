package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointTest {
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
}
