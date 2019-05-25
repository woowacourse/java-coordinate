package location.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FigureMakerTest {

    @Test
    void 선_생성_테스트() {
        List<Point> points = Arrays.asList(new Point(2, 6), new Point(3, 8));
        assertThat(FigureMaker.create(new Points(points))).isInstanceOf(Line.class);
    }

    @Test
    void 삼각형_생성_테스트() {
        List<Point> points = Arrays.asList(new Point(2, 6), new Point(3, 8), new Point(10, 24));
        assertThat(FigureMaker.create(new Points(points))).isInstanceOf(Triangle.class);
    }

    @Test
    void 사각형_생성_테스트() {
        List<Point> points = Arrays.asList(new Point(0, 0), new Point(2, 2), new Point(0, 2), new Point(2, 0));
        assertThat(FigureMaker.create(new Points(points))).isInstanceOf(Rectangle.class);
    }
}
