package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {
    @Test
    void 점이_일직선에_있으면_예외를_던지는지_테스트() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(new Coordinate(10), new Coordinate(3)));
        points.add(new Point(new Coordinate(10), new Coordinate(5)));
        points.add(new Point(new Coordinate(10), new Coordinate(10)));
        points.add(new Point(new Coordinate(10), new Coordinate(0)));


        assertThrows(IllegalArgumentException.class,()->new Rectangle(points));
    }

    @Test
    void 올바른_사격형을_생성했는지_테스트() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(new Coordinate(10), new Coordinate(10)));
        points.add(new Point(new Coordinate(22), new Coordinate(10)));
        points.add(new Point(new Coordinate(22), new Coordinate(18)));
        points.add(new Point(new Coordinate(10), new Coordinate(18)));

        new Rectangle(points);
    }

    @Test
    void 대각선으로_놓은_올바른_직사각형일_때_테스트() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(new Coordinate(10), new Coordinate(10)));
        points.add(new Point(new Coordinate(15), new Coordinate(15)));
        points.add(new Point(new Coordinate(15), new Coordinate(5)));
        points.add(new Point(new Coordinate(20), new Coordinate(10)));


        new Rectangle(points);
    }
}
