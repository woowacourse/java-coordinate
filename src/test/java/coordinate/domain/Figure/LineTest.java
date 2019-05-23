package coordinate.domain.Figure;

import coordinate.domain.point.Point;
import coordinate.domain.point.PointGroup;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineTest {
    @Test
    void 중복된_점_입력() {
        Set<Point> points = new HashSet<Point>() {{
            add(Point.create(1, 1));
            add(Point.create(1, 1));
        }};
        assertThrows(IllegalArgumentException.class, () -> {
            new Line(new PointGroup(points));
        });
    }

    @Test
    void 라인_길이() {
        Set<Point> points = new HashSet<Point>() {{
            add(Point.create(6, 3));
            add(Point.create(9, 7));
        }};
        assertEquals(5.0, new Line(new PointGroup(points)).length(), 0.1);
    }
}
