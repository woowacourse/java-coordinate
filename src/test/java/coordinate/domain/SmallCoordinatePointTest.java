package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmallCoordinatePointTest {
    @Test
    void 생성자_x_범위초과() {
        assertThrows(OutOfCoordinateException.class,
                () -> SmallCoordinatePoint.of(SmallCoordinatePoint.X_BEGIN - 1, SmallCoordinatePoint.Y_BEGIN));
    }

    @Test
    void 생성자_y_범위초과() {
        assertThrows(OutOfCoordinateException.class,
                () -> SmallCoordinatePoint.of(SmallCoordinatePoint.X_END - 1, SmallCoordinatePoint.Y_END));
    }
}