package coordinate.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ShapeFactoryTest {
    @Test
    void 라인_생성_테스트() {
        Point p1 = new Point(new PointNumber(1), new PointNumber(1));
        Point p2 = new Point(new PointNumber(3), new PointNumber(1));
        List<Point> points = Arrays.asList(p1, p2);
        Shape shape = ShapeFactory.create(points);

        assertThat(shape.getClass()).isEqualTo(Line.class);
    }

    @Test
    void 삼각형_생성_테스트() {
        Point p1 = new Point(new PointNumber(10), new PointNumber(10));
        Point p2 = new Point(new PointNumber(14), new PointNumber(15));
        Point p3 = new Point(new PointNumber(20), new PointNumber(8));
        List<Point> points = Arrays.asList(p1, p2, p3);
        Shape shape = ShapeFactory.create(points);

        assertThat(shape.getClass()).isEqualTo(Triangle.class);
    }

    @Test
    void 사각형_생성_테스트() {
        Point p1 = new Point(new PointNumber(1), new PointNumber(1));
        Point p2 = new Point(new PointNumber(3), new PointNumber(1));
        Point p3 = new Point(new PointNumber(1), new PointNumber(3));
        Point p4 = new Point(new PointNumber(3), new PointNumber(3));
        List<Point> points = Arrays.asList(p1, p2, p3, p4);
        Shape shape = ShapeFactory.create(points);

        assertThat(shape.getClass()).isEqualTo(Square.class);
    }
}