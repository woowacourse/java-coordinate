package coordinatecalculator.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {
    @Test
    void 중복_좌표() {
        Point point1 = Point.of(0, 0);
        Point point2 = Point.of(0, 0);
        List<Point> points = Arrays.asList(point1, point2);

        assertThrows(IllegalArgumentException.class, () -> {
            new Line(points);
        });
    }
}