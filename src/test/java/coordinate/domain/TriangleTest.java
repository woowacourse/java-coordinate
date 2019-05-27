package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {
    @Test
    public void 삼각형이_생성될_수없는_좌표일_때_테스트() {
        List<Point> points = Arrays.asList(
                new Point(10, 10),
                new Point(15, 15),
                new Point(20, 20)
        );

        assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(points);
        });
    }

    @Test
    public void 삼각형이_제대로_생성되는지_테스트() {
        List<Point> points = Arrays.asList(
                new Point(10, 10),
                new Point(14, 15),
                new Point(20, 8)
        );

        new Triangle(points);
    }

    @Test
    public void 삼각형의_넓이를_잘_구하는지_테스트() {
        List<Point> points = Arrays.asList(
                new Point(10, 10),
                new Point(14, 15),
                new Point(20, 8)
        );

        assertThat(new Triangle(points).area()).isEqualTo(29, offset(0.00099));
    }
}
