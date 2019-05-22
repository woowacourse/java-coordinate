package coordinate.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {
    @Test
    void 삼각형_중복_검사() {
        Point p1 = new Point(new PointNumber(3), new PointNumber(3));
        Point p2 = new Point(new PointNumber(3), new PointNumber(3));
        Point p3 = new Point(new PointNumber(2), new PointNumber(2));
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(Arrays.asList(p1, p2, p3));
        });
    }

    @Test
    void 삼각형_1라인_검사() {
        Point p1 = new Point(new PointNumber(3), new PointNumber(3));
        Point p2 = new Point(new PointNumber(1), new PointNumber(1));
        Point p3 = new Point(new PointNumber(2), new PointNumber(2));
        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(Arrays.asList(p1, p2, p3));
        });
    }

    @Test
    void 삼각형_넓이_계산() {
        Point p1 = new Point(new PointNumber(0), new PointNumber(0));
        Point p2 = new Point(new PointNumber(0), new PointNumber(2));
        Point p3 = new Point(new PointNumber(2), new PointNumber(0));
        assertThat((new Triangle(Arrays.asList(p1, p2, p3))).getArea()).isEqaulTo(2);
    }
}
