package coordinate.domain;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleTest {

    @Test
    void 삼각형예외() {
        Points points = new Points(Arrays.asList(new Point(1, 0), new Point(2, 0), new Point(3, 0)));
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Triangle(points);
        });
    }

    @Test
    void 삼각형넓이() {
        Points points = new Points(Arrays.asList(new Point(0, 0), new Point(2, 0), new Point(0, 2)));
        assertEquals(new Triangle(points).calculateArea(), 2, 0.001);
    }
}
