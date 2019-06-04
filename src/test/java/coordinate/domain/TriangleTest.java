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

    @Test
    void 팩토리() {
        Figure triangle = FigureFactory.figure(Arrays.asList(new Point(1, 1), new Point(1, 10), new Point(10, 1)));
        assertEquals(40.5, triangle.area(), 0.1);
    }

    @Test
    void 삼각형_직선상() {
        assertThrows(IllegalArgumentException.class,
                () -> FigureFactory.figure(PointGenerator.trans(Arrays.asList(1, 1, 2, 2, 3, 3))));
    }

    @Test
    void 수직() {
        assertEquals(4.0, FigureFactory.figure(PointGenerator.trans(Arrays.asList(1, 1, 3, 1, 3, 5))).area(), 0.1);
    }
}