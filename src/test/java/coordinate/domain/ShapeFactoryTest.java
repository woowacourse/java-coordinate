package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ShapeFactoryTest {
    @Test
    void 사각형_판별하는_테스트() {
        Points points = new Points(Arrays.asList(new Point(1, 1), new Point(3, 1),
                new Point(1, 2), new Point(3, 2)));
        Shape firstShape = ShapeFactory.create(points);
        assertThat(firstShape).isEqualTo(new Rectangle(points));
    }

    @Test
    void 삼각형_판별하는_테스트() {
        Points points = new Points(Arrays.asList(new Point(1, 1), new Point(3, 1), new Point(1, 2)));
        Shape firstShape = ShapeFactory.create(points);
        assertThat(firstShape).isEqualTo(new Triangle(points));
    }

    @Test
    void 라인_판별하는_테스트() {
        Points points = new Points(Arrays.asList(new Point(1, 1), new Point(3, 1)));
        Shape firstShape = ShapeFactory.create(points);
        assertThat(firstShape).isEqualTo(new Line(points));
    }
}
