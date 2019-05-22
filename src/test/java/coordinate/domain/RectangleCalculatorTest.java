package coordinate.domain;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleCalculatorTest {
    @Test
    void 직사각형_아닌_입력() {
        List<Point> points = Arrays.asList(
                new Point(10,10),
                new Point(22,10),
                new Point(22,18),
                new Point(10,19)
        );
        assertThrows(IllegalArgumentException.class,()->{
            new RectangleCalculator(new Figure(points));
        });
    }

    @Test
    void 면적_계산() {
        List<Point> points = Arrays.asList(
                new Point(10,10),
                new Point(22,10),
                new Point(22,18),
                new Point(10,18)
        );
        RectangleCalculator rectangleCalculator = new RectangleCalculator(new Figure(points));
        assertThat(rectangleCalculator.getArea()).isEqualTo(96, Offset.offset(0.0099));
    }
}
