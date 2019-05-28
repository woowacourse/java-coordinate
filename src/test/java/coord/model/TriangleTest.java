package coord.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void area() {
        Points points = new Points(Arrays.asList(new Point(1, 10),
                new Point(1, 1), new Point(5, 1)));
        assertEquals(18.0, Figure.getInstance(points).area(), 0.001);
    }
}