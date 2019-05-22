package coord.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void areaTest() {
        assertEquals(36.0, Figure.fromPoints(new Points(Arrays.asList(new Point(1, 10), new Point(1, 1), new Point (5, 1), new Point (5, 10)))).area(), 0.001);
    }
}