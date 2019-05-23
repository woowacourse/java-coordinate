package coord.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    @Test
    void isOnTheSameLineWithTestA() {
        assertEquals(true, new Line(new Point(2, 4), new Point(0, 0)).includes(new Point(1, 2)));
    }

    @Test
    void isOnTheSameLineWithTestB() {
        assertEquals(true, new Line(new Point(2, 2), new Point(4, 2)).includes(new Point(3, 2)));
    }

    @Test
    void isOnTheSameLineWithTestC() {
        assertEquals(true, new Line(new Point(2, 4), new Point(2, 0)).includes(new Point(2, 3)));
    }
}