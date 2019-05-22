package coordinate.domain;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TriangleCalculatorTest {
    @Test
    void 면적_계산() {
        List<Point> points = Arrays.asList(
                new Point(10, 10),
                new Point(14, 15),
                new Point(20, 8)
        );
        TriangleCalculator triangleCalculator = new TriangleCalculator(new Figure(points));
        assertThat(triangleCalculator.getArea()).isEqualTo(29, Offset.offset(0.0099));
    }
}