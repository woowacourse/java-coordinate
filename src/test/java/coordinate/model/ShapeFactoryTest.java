package coordinate.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShapeFactoryTest {

    @Test
    void 라인_생성_테스트() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(3, 1);
        List<Point> points = Arrays.asList(p1, p2);
        Shape shape = ShapeFactory.create(points);

        assertThat(shape.getClass()).isEqualTo(Line.class);
    }

    @Test
    void 삼각형_생성_테스트() {
        Point p1 = new Point(10, 10);
        Point p2 = new Point(14, 15);
        Point p3 = new Point(20, 8);
        List<Point> points = Arrays.asList(p1, p2, p3);
        Shape shape = ShapeFactory.create(points);

        assertThat(shape.getClass()).isEqualTo(Triangle.class);
    }

    @Test
    void 사각형_생성_테스트() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(3, 1);
        Point p3 = new Point(1, 3);
        Point p4 = new Point(3, 3);
        List<Point> points = Arrays.asList(p1, p2, p3, p4);
        Shape shape = ShapeFactory.create(points);

        assertThat(shape.getClass()).isEqualTo(Square.class);
    }

    @Test
    void 좌표가_1개_예외() {
        Point p1 = new Point(1, 1);
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.create(Arrays.asList(p1));
        });
    }

    @Test
    void 좌표가_5개_예외() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(3, 1);
        Point p3 = new Point(1, 3);
        Point p4 = new Point(3, 3);
        Point p5 = new Point(4, 4);
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.create(Arrays.asList(p1, p2, p3, p4, p5));
        });
    }
}