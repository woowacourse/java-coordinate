package coord.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void area() {
        Points points = new Points(Arrays.asList(new Point(1, 10),
                new Point(1, 1), new Point(5, 1)));
        assertEquals(18.0, FigureFactory.getInstance(points).area(), 0.001);
    }

    @Test
    void 넓이가_0인_삼각형1() {
        Points points = new Points(Arrays.asList(new Point(2, 2),
                new Point(1, 1), new Point(3, 3)));
        assertThrows(IllegalArgumentException.class, () -> FigureFactory.getInstance(points).area());
    }

    @Test
    void 넓이가_0인_삼각형2() {
        Points points = new Points(Arrays.asList(new Point(2, 3),
                new Point(1, 1), new Point(3, 5)));
        assertThrows(IllegalArgumentException.class, () -> FigureFactory.getInstance(points).area());
    }
}