package coordinate.domain;

import coordinate.domain.point.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {
    @Test
    void 좌표두개1() {
        Point coordinate = Point.create(5, 3);
        assertEquals(coordinate.squaredDistanceFrom(Point.create(9, 7))
                , 32, 0.1);
    }

    @Test
    void 좌표두개2() {
        Point coordinate = Point.create(0, 0);
        assertEquals(coordinate.squaredDistanceFrom(Point.create(0, 0))
                , 0.0, 0.1);
    }
}