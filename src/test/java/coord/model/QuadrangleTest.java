package coord.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuadrangleTest {

    @Test
    void areaTest() {
        Points points = new Points(Arrays.asList(new Point(1, 10),
                new Point(1, 1), new Point(5, 1), new Point(5, 10)));
        assertEquals(36.0,
                Figure.fromPoints(points).area(), 0.001);
    }

    @Test
    void 비정형() {
        Points points = new Points(Arrays.asList(new Point(1, 1),
                new Point(10, 7), new Point(15, 10), new Point(3, 20)));

        assertEquals(122.5, Figure.fromPoints(points).area(), 0.1);
    }
}