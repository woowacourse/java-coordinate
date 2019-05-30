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
}