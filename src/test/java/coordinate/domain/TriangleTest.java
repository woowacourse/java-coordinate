package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {
    @Test
    public void 삼각형이_생성될_수없는_좌표일_때_테스트() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(new Coordinate(10), new Coordinate(10)));
        points.add(new Point(new Coordinate(15), new Coordinate(15)));
        points.add(new Point(new Coordinate(20), new Coordinate(20)));

        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(points);
        });
    }

    @Test
    public void 삼각형이_제대로_생성되는지_테스트() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(new Coordinate(10), new Coordinate(10)));
        points.add(new Point(new Coordinate(14), new Coordinate(15)));
        points.add(new Point(new Coordinate(20), new Coordinate(8)));

        new Triangle(points);
    }

    @Test
    public void 삼각형의_넓이를_잘_구하는지_테스트() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(new Coordinate(10), new Coordinate(10)));
        points.add(new Point(new Coordinate(14), new Coordinate(15)));
        points.add(new Point(new Coordinate(20), new Coordinate(8)));

        assertThat(new Triangle(points).area()).isEqualTo(29, offset(0.00099));
    }
}
