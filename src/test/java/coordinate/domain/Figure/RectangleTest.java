package coordinate.domain.Figure;

import coordinate.domain.point.Point;
import coordinate.domain.point.PointGroup;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {
    @Test
    void 직사각형() {
        Set<Point> points = new HashSet<Point>() {{
            add(Point.create(1, 1));
            add(Point.create(4, 1));
            add(Point.create(4, 3));
            add(Point.create(1, 3));

        }};
        assertDoesNotThrow(() -> {
            new Rectangle(new PointGroup(points));
        });
    }

    @Test
    void 정사각형() {
        Set<Point> points = new HashSet<Point>() {{
            add(Point.create(1, 1));
            add(Point.create(2, 1));
            add(Point.create(2, 2));
            add(Point.create(1, 2));

        }};
        assertDoesNotThrow(() -> {
            new Rectangle(new PointGroup(points));
        });
    }

    @Test
    void 직사각형_아닌_경우() {
        Set<Point> points = new HashSet<Point>() {{
            add(Point.create(1, 1));
            add(Point.create(4, 1));
            add(Point.create(5, 3));
            add(Point.create(1, 3));

        }};
        assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(new PointGroup(points));
        });
    }

    @Test
    void 직사각형_넓이() {
        Set<Point> points = new HashSet<Point>() {{
            add(Point.create(1, 1));
            add(Point.create(4, 1));
            add(Point.create(4, 3));
            add(Point.create(1, 3));

        }};
        assertThat(new Rectangle(new PointGroup(points)).area()).isEqualTo(6);
    }

    @Test
    void 정사각형_넓이() {
        Set<Point> points = new HashSet<Point>() {{
            add(Point.create(1, 1));
            add(Point.create(2, 1));
            add(Point.create(2, 2));
            add(Point.create(1, 2));

        }};
        assertThat(new Rectangle(new PointGroup(points)).area()).isEqualTo(1);
    }
}


