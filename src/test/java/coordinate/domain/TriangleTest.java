package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class TriangleTest {
    @Test
    public void Point가_3개_미만_들어올_경우() {
        List<Point> points = new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(2, 2)));

        assertThatThrownBy(() -> {
            new Triangle(points);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Point가_3개_초과_들어올_경우() {
        List<Point> points = new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(2, 2), new Point(3, 3), new Point(4, 4)));

        assertThatThrownBy(() -> {
            new Triangle(points);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 넓이를_잘_구하는지_확인() {
        List<Point> points = new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(6, 1), new Point(3, 16)));
        Triangle triangle = new Triangle(points);

        assertThat(triangle.area()).isEqualTo(37.5, offset(0.00099));
    }
}
