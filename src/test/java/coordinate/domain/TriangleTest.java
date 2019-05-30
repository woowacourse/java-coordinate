package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void 생성() {
        Triangle triangle = new Triangle(Arrays.asList(new Point(1, 1), new Point(1, 10), new Point(10, 1)));
        assertEquals(40.5, triangle.area(), 0.1);
    }
}