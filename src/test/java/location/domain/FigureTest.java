package location.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FigureTest {

    @Test
    void 동일한_점_일때_라인() {
        assertThrows(IllegalArgumentException.class, () -> new Line(new Points(Arrays.asList(new Point(10, 10), new Point(10, 10)))));
    }

    @Test
    void 동일한_점_일때_삼각형() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(new Points(Arrays.asList(new Point(10, 10), new Point(10, 10), new Point(10, 10)))));
    }

    @Test
    void 동일한_점_일때_사각형() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(new Points(Arrays.asList(new Point(10, 10), new Point(10, 10), new Point(10, 10), new Point(10, 10)))));
    }

}
