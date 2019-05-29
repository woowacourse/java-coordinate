package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class TriangleTest {
    @Test
    void area_() {
        Points points = Points.from(Arrays.asList(
                new DefaultPoint(10, 10),
                new DefaultPoint(14, 15),
                new DefaultPoint(20, 8)));
        Triangle triangle = Triangle.from(points);

        assertThat(triangle.area()).isEqualTo(29.0, offset(0.00099));
    }
}
