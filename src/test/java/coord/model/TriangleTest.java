package coord.model;

import coord.model.figure.Figure;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleTest {
    @Test
    void areaTest() {
        assertEquals(18.0, Figure.getConvexPolygon(new Point(1, 10), new Point(5, 1), new Point (1, 1)).area(), 0.001);
    }
}