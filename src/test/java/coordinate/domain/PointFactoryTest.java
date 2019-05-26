package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointFactoryTest {
    private final int xBegin = 0;
    private final int yBegin = 0;
    private final int len = 10;

    @Test
    void of_x축_존재할수없는범위() {
        assertThrows(IllegalArgumentException.class, () -> PointFactory.of(xBegin, xBegin, yBegin, yBegin + 1));
    }

    @Test
    void of_y축_존재할수없는범위() {
        assertThrows(IllegalArgumentException.class, () -> PointFactory.of(xBegin, xBegin + 1, yBegin, yBegin));
    }

    @Test
    void createPoint_x_범위를초과하는_입력() {
        PointFactory factory = PointFactory.of(xBegin, xBegin + len, yBegin, yBegin + len);

        assertThrows(IllegalArgumentException.class, () -> factory.createPoint(xBegin - 1, yBegin));
    }

    @Test
    void createPoint_y_범위를초과하는_입력() {
        int yEnd = yBegin + len;
        PointFactory factory = PointFactory.of(xBegin, xBegin + len, yBegin, yEnd);

        assertThrows(IllegalArgumentException.class, () -> factory.createPoint(xBegin, yEnd));
    }
}