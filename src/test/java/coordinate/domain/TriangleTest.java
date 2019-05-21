package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TriangleTest {
    @Test
    public void Point가_3개_이상_들어올_경우() {
        List<Point> points = new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(2, 2), new Point(3, 3), new Point(4, 4)));

        assertThatThrownBy(() -> {
            new Triangle(points);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 넓이를_잘_구하는지_확인() {
        List<Point> points = new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(1, 5), new Point(5, 1)));
        Triangle triangle = new Triangle(points);

        assertThat(triangle.area()).isEqualTo(0);
    }
}
