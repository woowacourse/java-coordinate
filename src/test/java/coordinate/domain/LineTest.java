package coordinate.domain;

import coordinate.domain.figure.Line;
import coordinate.domain.nonefigure.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTest {
    @Test
    void 라인_길이() {
        Point point1 = Point.create(6, 3);
        Point point2 = Point.create(9, 7);
        Line line = new Line(point1, point2);
        assertEquals(5.0, line.length(), 0.1);
    }
}
