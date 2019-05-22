package coordinatecalculator.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {
    @Test
    void create() {
        List<Point> points = Arrays.asList(new Point("0", "0"), new Point("1", "0"), new Point("0", "1"));
        assertThat(new Triangle(new Points(points))).isEqualTo(new Triangle(new Points(points)));
    }

    @Test
    void 삼각형_넓이_계산() {
        List<Point> points = Arrays.asList(new Point("0", "0"), new Point("1", "0"), new Point("0", "1"));
        Triangle triangle = new Triangle(new Points(points));
        assertEquals(0.5, triangle.calculateResult(), 0.001);
    }
}
