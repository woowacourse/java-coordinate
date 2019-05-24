package coordinate.domain.figure;

import coordinate.domain.point.Point;
import coordinate.domain.point.PointGroup;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTest {
    @Test
    void 라인_길이() {
        List<Point> points = Arrays.asList(
                Point.create(6, 3), Point.create(9, 7)
        );

        assertEquals(5.0, new Line(new PointGroup(points)).length(), 0.1);
    }
}
