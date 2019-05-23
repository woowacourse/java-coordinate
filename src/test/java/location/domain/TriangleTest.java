package location.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {
    @Test
    void 넓이() {
        Points points = new Points(Arrays.asList(new Point(3, 5), new Point(4, 15), new Point(5, 5)));
        Triangle triangle = new Triangle(points);
        assertThat(triangle.calculate()).isEqualTo(10);
    }

    @Test
    void 한_라인에_모두_있을때() {
        Points points = new Points(Arrays.asList(new Point(3, 5), new Point(4, 5), new Point(5, 5)));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(points));
    }

    @Test
    void 한_대각선에_모두_있을때() {
        Points points = new Points(Arrays.asList(new Point(1, 1), new Point(2, 2), new Point(4, 4)));
        assertThrows(IllegalArgumentException.class, () -> new Triangle(points));
    }

}
