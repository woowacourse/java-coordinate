package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class TriangleTest {
    @Test
    public void Point가_3개_미만_들어올_경우() {
        Vertices vertices = new Vertices(new ArrayList<>(Arrays.asList(new Point(1, 1),
                new Point(1, 5))));

        assertThatThrownBy(() -> {
            new Triangle(vertices);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Point가_3개_이상_들어올_경우() {
        Vertices vertices = new Vertices(new ArrayList<>(Arrays.asList(new Point(1, 1),
                new Point(1, 5),
                new Point(5, 1),
                new Point(5, 5))));

        assertThatThrownBy(() -> {
            new Triangle(vertices);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 넓이를_잘_구하는지_확인() {
        Vertices vertices = new Vertices(new ArrayList<>(Arrays.asList(new Point(1, 1),
                new Point(6, 1),
                new Point(3, 16))));

        Triangle triangle = new Triangle(vertices);

        assertThat(triangle.area()).isEqualTo(37.5, offset(0.00099));
    }
}
