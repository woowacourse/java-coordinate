package coord.model.figure;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class TriangleTest {
    @Test
    void areaTest() {
        assertThat(ConvexPolygonFactory.makeFrom(
                new Point(1, 10), new Point(5, 1), new Point (1, 1)).area()
        ).isCloseTo(18.0, offset(0.0000001));
    }
}