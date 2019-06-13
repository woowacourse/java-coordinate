package coordinate.domain.figure;

import coordinate.domain.figure.line.Line;
import coordinate.domain.figure.rectangle.Rectangle;
import coordinate.domain.figure.triangle.Triangle;
import coordinate.domain.point.Point;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FigureFactoryTest {
    @Test
    void 라인_생성() {
        List<Point> points = Arrays.asList(new Point(1,1), new Point(1,2));
        assertThat(FigureFactory.getFigure(points)).isEqualTo(new Line(points));
    }

    @Test
    void 삼각형_생성() {
        List<Point> points = Arrays.asList(
                new Point(1,1),
                new Point(2,3),
                new Point(3,4)
        );
        assertThat(FigureFactory.getFigure(points)).isEqualTo(new Triangle(points));
    }

    @Test
    void 사각형_생성() {
        List<Point> points = Arrays.asList(
                new Point(0,0),
                new Point(1,0),
                new Point(1,1),
                new Point(0,1)
        );
        List<Point> sortedPoint = Arrays.asList(
                new Point(0,0),
                new Point(0,1),
                new Point(1,1),
                new Point(1,0)
        );
        assertThat(FigureFactory.getFigure(points)).isEqualTo(new Rectangle(sortedPoint));
    }

    @Test
    void 유효하지_않는_도형() {
        List<Point> points = Arrays.asList(
                new Point(0,0),
                new Point(1,0),
                new Point(1,1),
                new Point(0,1),
                new Point(0,2)
        );
        assertThrows(InvalidFigureException.class, () -> {
            FigureFactory.getFigure(points);
        });
    }
}
