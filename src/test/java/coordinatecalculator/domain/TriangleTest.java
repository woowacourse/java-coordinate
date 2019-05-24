package coordinatecalculator.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {
    @Test
    void create() {
        List<Point> points = Arrays.asList(new Point("0", "0"), new Point("1", "0"), new Point("0", "1"));
        assertThat(Triangle.newInstance(new Points(points))).isEqualTo(Triangle.newInstance(new Points(points)));
    }

    @Test
    void 삼각형_넓이_계산() {
        List<Point> points = Arrays.asList(new Point("0", "0"), new Point("1", "0"), new Point("0", "1"));
        Triangle triangle = Triangle.newInstance(new Points(points));
        assertEquals(0.5, triangle.calculateResult(), 0.001);
    }

    @Test
    void 세점이_일직선상에_있을경우_예외처리() {
        List<Point> points = Arrays.asList(new Point("0", "0"), new Point("1", "1"), new Point("2", "2"));
        assertThrows(IllegalArgumentException.class, () -> Triangle.newInstance(new Points(points)));
    }

    @Test
    void 세점의_x좌표가_동일할_경우_예외처리() {
        List<Point> points = Arrays.asList(new Point("0", "0"), new Point("0", "1"), new Point("0", "2"));
        assertThrows(IllegalArgumentException.class, () -> Triangle.newInstance(new Points(points)));
    }
}
