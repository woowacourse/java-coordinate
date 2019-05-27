package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class TriangleTest {
    @Test
    void 삼각형_유효성_정상_테스트() {
        Points points = new Points(Arrays.asList(
                new Point(new Scalar(0), new Scalar(0)),
                new Point(new Scalar(1), new Scalar(0)),
                new Point(new Scalar(0), new Scalar(1))
        ));
        assertThat(Triangle.isTriangle(points)).isTrue();
    }

    @Test
    void 삼각형_유효성_예외_테스트() {
        Points points = new Points(Arrays.asList(
                new Point(new Scalar(0), new Scalar(0)),
                new Point(new Scalar(0), new Scalar(1)),
                new Point(new Scalar(0), new Scalar(2))
        ));
        assertThat(Triangle.isTriangle(points)).isFalse();
    }

    @Test
    void 삼각형_넓이_구하는_테스트() {
        Points points = new Points(Arrays.asList(
                new Point(new Scalar(0), new Scalar(0)),
                new Point(new Scalar(1), new Scalar(0)),
                new Point(new Scalar(0), new Scalar(1))
        ));
        Triangle triangle = new Triangle(points);
        assertThat(triangle.calculateFigure()).isEqualTo(0.5, offset(0.00099));
    }
}
