package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void 넓이() {
        Rectangle rectangle = new Rectangle(PointGenerator.trans(Arrays.asList(1, 1, 10, 1, 10, 10, 1, 10)));
        assertEquals(81.0, rectangle.area(), 0.1);
    }

    @Test
    void 팩토리() {
        Figure rectangle = FigureFactory.figure(PointGenerator.trans(Arrays.asList(1, 10, 10, 1, 10, 10, 1, 1)));
        assertEquals(81.0, rectangle.area(), 0.1);
    }

    @Test
    void 직사각형_아님() {
        assertThrows(IllegalArgumentException.class,
                () -> FigureFactory.figure(PointGenerator.trans(Arrays.asList(1, 1, 3, 2, 4, 5, 7, 7))));
    }
}