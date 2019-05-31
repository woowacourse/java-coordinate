package coordinate.domain.shape;

import coordinate.domain.point.Point;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {
    @Test
    public void 점이_일직선에_있으면_예외를_던지는지_테스트() {
        List<Point> points = Arrays.asList(
                new Point(10, 3),
                new Point(10, 5),
                new Point(10, 10),
                new Point(10, 0)
        );

        assertThrows(IllegalArgumentException.class, () -> new Rectangle(points));
    }

    @Test
    public void 올바른_사각형을_생성했는지_테스트() {
        List<Point> points = Arrays.asList(
                new Point(10, 10),
                new Point(22, 10),
                new Point(22, 18),
                new Point(10, 18)
        );

        new Rectangle(points);
    }

    @Test
    public void 대각선으로_놓은_올바른_직사각형일_때_테스트() {
        List<Point> points = Arrays.asList(
                new Point(10, 10),
                new Point(15, 15),
                new Point(15, 5),
                new Point(20, 10)
        );

        new Rectangle(points);
    }

    @Test
    void 직사각형의_올바른_넓이를_구하는지_테스트() {
        List<Point> points = Arrays.asList(
                new Point(10, 10),
                new Point(22, 10),
                new Point(22, 18),
                new Point(10, 18)
        );

        assertThat(new Rectangle(points).area()).isEqualTo(96);
    }

    @Test
    void 정사각형의_올바른_넓이를_구하는지_테스트() {
        List<Point> points = Arrays.asList(
                new Point(10, 10),
                new Point(20, 10),
                new Point(10, 20),
                new Point(20, 20)
        );

        assertThat(new Rectangle(points).area()).isEqualTo(100);
    }
}
