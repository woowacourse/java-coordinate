package coord.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void area() {
        assertEquals(18.0, Figure.getInstance(new Points(Arrays.asList(new Point(1, 10), new Point(1, 1), new Point(5, 1)))).area(), 0.001);
    }
}