package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class TriangleTest {
    @Test
    void 삼각형_넓이_계산() {
        Points points = new Points(Arrays.asList(new Point(1, 5), new Point(1, 1), new Point(5, 1)));
        assertThat(new Triangle(points).getArea()).isEqualTo(8);
    }
}
