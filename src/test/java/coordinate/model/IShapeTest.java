package coordinate.model;

import coordinate.model.framework.IShape;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class IShapeTest {
        @Test
        void 라인_생성_테스트() {
                Point p1 = new Point(1, 1);
                Point p2 = new Point(3, 1);
                List<Point> points = Arrays.asList(p1, p2);
                IShape shape = IShape.MAPPING_SHAPE.get(points.size()).apply(points);

                assertThat(shape.getClass()).isEqualTo(Line.class);
        }

        @Test
        void 삼각형_생성_테스트() {
                Point p1 = new Point(10, 10);
                Point p2 = new Point(14, 15);
                Point p3 = new Point(20, 8);
                List<Point> points = Arrays.asList(p1, p2, p3);
                IShape shape = IShape.MAPPING_SHAPE.get(points.size()).apply(points);

                assertThat(shape.getClass()).isEqualTo(Triangle.class);
        }


        @Test
        void 사각형_생성_테스트() {
                Point p1 = new Point(1, 1);
                Point p2 = new Point(3, 1);
                Point p3 = new Point(1, 3);
                Point p4 = new Point(3, 3);
                List<Point> points = Arrays.asList(p1, p2, p3, p4);
                IShape shape = IShape.MAPPING_SHAPE.get(points.size()).apply(points);

                assertThat(shape.getClass()).isEqualTo(Square.class);
        }
}