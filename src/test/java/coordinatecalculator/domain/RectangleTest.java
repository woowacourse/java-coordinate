package coordinatecalculator.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTest {
    @Test
    void 좌표_정렬() {
        List<Point> points = new ArrayList<>(PointTest.rectangle);
        Collections.shuffle(points);
        new Rectangle(points);

        assertThat(points).isEqualTo(PointTest.rectangle);
    }

    @Test
    void 직사각형이_아닌_경우() {
        Point p5 = Point.of(1, 2);
        List<Point> points = new ArrayList<>(PointTest.rectangle);
        points.set(points.size() - 1, p5);

        assertThrows(IllegalArgumentException.class, () -> {
            new Rectangle(points);
        });
    }

    @Test
    void 넓이() {
        AbstractFigure answer2 = new Rectangle(PointTest.rectangle);
        assertThat(answer2.area()).isEqualTo(1);
    }
}