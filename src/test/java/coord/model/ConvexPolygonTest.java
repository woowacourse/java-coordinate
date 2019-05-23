package coord.model;

import coord.model.figure.Figure;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConvexPolygonTest {
    @Test
    void initTestA() {
        assertThrows(Exception.class, () -> Figure.getConvexPolygon(new Point(1, 2), new Point(2, 4), new Point(4, 8)));
    }

    @Test
    void initTestB() {
        Figure.getConvexPolygon(new Point(1, 2), new Point(2, 4), new Point(4, 8), new Point(6, 5));
    }

    @Test
    void initTestC() {
        Figure.getConvexPolygon(new Point(10, 10), new Point (10, 0), new Point(5, 5), new Point (15, 5));
    }

    @Test
    void initTestD() {
        assertThrows(Exception.class, () -> Figure.getConvexPolygon(new Point(0, 10), new Point (10, 0), new Point(0, 0), new Point (2, 3)));
    }

    @Test
    void areaTestA() {
        assertEquals(36.0, Figure.getConvexPolygon(new Point(1, 10), new Point(1, 1), new Point (5, 1), new Point (5, 10)).area(), 0.001);
    }

    @Test
    void areaTestB() {
        assertEquals(50.0, Figure.getConvexPolygon(new Point(10, 10), new Point (10, 0), new Point(5, 5), new Point (15, 5)).area(), 0.001);
    }

    @Test
    void areaTestC() {
        assertEquals(38.5, Figure.getConvexPolygon(
                new Point(0, 0),
                new Point (8, 9),
                new Point(4, 7),
                new Point (10, 6),
                new Point(7, 3),
                new Point(1, 0)).area(), 0.001);
    }
}