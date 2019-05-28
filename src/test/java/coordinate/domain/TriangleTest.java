package coordinate.domain;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    @Test
    void 면적_계산() {
        List<Point> points = Arrays.asList(
                new Point(10, 10),
                new Point(14, 15),
                new Point(20, 8)
        );
        Triangle triangle = new Triangle(new Points(points));
        assertThat(triangle.area()).isEqualTo(29, Offset.offset(0.0099));
    }

    @Test
    void 일직선_입력() {
        List<Point> points = Arrays.asList(
                new Point(10, 10),
                new Point(11, 10),
                new Point(14, 10)
        );
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(new Points(points));
        });
    }
}