package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FigureGeneratorTest {
    @Test
    public void Point_2개_입력됐을_때_Line을_만드는지_확인() {
        List<Point> points = new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(2, 2)));

        assertThat(new FigureGenerator().generate(new Points(points))).isExactlyInstanceOf(Line.class);
    }

    @Test
    public void Point_3개_입력됐을_때_Triangle을_만드는지_확인() {
        List<Point> points = new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(2, 2), new Point(4, 3)));

        assertThat(new FigureGenerator().generate(new Points(points))).isExactlyInstanceOf(Triangle.class);
    }

    @Test
    public void Point_4개_입력됐을_때_Rectangle을_만드는지_확인() {
        List<Point> points = new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(1, 2), new Point(2, 1), new Point(2, 2)));

        assertThat(new FigureGenerator().generate(new Points(points))).isExactlyInstanceOf(Rectangle.class);
    }

    @Test
    public void Point_5개_입력됐을_때_예외를_던지는지_확인() {
        List<Point> points = new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(1, 2), new Point(2, 1), new Point(2, 2), new Point(5, 5)));

        assertThatThrownBy(() -> {
            new FigureGenerator().generate(new Points(points));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 세_점이_한_직선상에_있을_때_예외를_던지는지_확인() {
        List<Point> points = new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(2, 2), new Point(3, 3)));

        assertThatThrownBy(() -> {
            new FigureGenerator().generate(new Points(points));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
