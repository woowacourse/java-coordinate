package coordinate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    @Test
    void 비교() {
        Point point = new Point(1, 2);
        assertEquals(new Point(1, 2), new Point(1, 2));
    }
}