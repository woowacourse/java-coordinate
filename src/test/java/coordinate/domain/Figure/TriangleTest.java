package coordinate.domain.Figure;

import coordinate.domain.point.Point;
import coordinate.domain.point.PointGroup;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {
    @Test
    void 삼각형_넓이() {
        Set<Point> points = new HashSet<Point>() {{
            add(Point.create(1, 1));
            add(Point.create(2, 2));
            add(Point.create(1, 3));
        }};
        assertThat(new Triangle(new PointGroup(points)).area()).isEqualTo(1);
    }

    @Test
    void 일직선_세_점() {
        Set<Point> points = new HashSet<Point>() {{
            add(Point.create(1, 1));
            add(Point.create(1, 2));
            add(Point.create(1, 3));
        }};
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(new PointGroup(points));
        });
    }
}