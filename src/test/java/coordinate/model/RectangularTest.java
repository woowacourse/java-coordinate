package coordinate.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangularTest {
    @Test
    void 사각형_생성_검사() {
        assertThrows(IllegalArgumentException.class, () -> {
            Point p1 = new Point(new PointNumber(0), new PointNumber(0));
            Point p2 = new Point(new PointNumber(0), new PointNumber(0));
            Point p3 = new Point(new PointNumber(0), new PointNumber(2));
            Point p4 = new Point(new PointNumber(3), new PointNumber(3));
            new Rectangular(Arrays.asList(p1, p2, p3, p4));
        });
    }

    @Test
    void 사각형_뒤틀림_검사() {
        assertThrows(IllegalArgumentException.class, () -> {
            Point p1 = new Point(new PointNumber(0), new PointNumber(0));
            Point p2 = new Point(new PointNumber(2), new PointNumber(0));
            Point p3 = new Point(new PointNumber(0), new PointNumber(2));
            Point p4 = new Point(new PointNumber(3), new PointNumber(3));
            new Rectangular(Arrays.asList(p1, p2, p3, p4));
        });
    }

    @Test
    void 사각형_넓이_계산() {
        Point p1 = new Point(new PointNumber(0), new PointNumber(0));
        Point p2 = new Point(new PointNumber(2), new PointNumber(0));
        Point p3 = new Point(new PointNumber(0), new PointNumber(2));
        Point p4 = new Point(new PointNumber(2), new PointNumber(2));
        assertThat((new Rectangular(Arrays.asList(p1, p2, p3, p4)).getArea())).isEqualTo(4);
    }
}
