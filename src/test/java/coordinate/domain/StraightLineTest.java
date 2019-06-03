package coordinate.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StraightLineTest {
    Point testPoint;
    Point testPoint2;
    Points points;
    StraightLine straightLine;

    @BeforeEach
    void setUp() {
        testPoint = new Point(Arrays.asList(1, 1));
        testPoint2 = new Point(Arrays.asList(2, 2));
        points = Points.of(Arrays.asList(testPoint, testPoint2));
        straightLine = new StraightLine(points);
    }

    @Test
    void 좌표가_두개가_아닐때_예외를_던지는지_테스트() {
        Points points = Points.of(Arrays.asList(testPoint));

        assertThrows(IllegalArgumentException.class, () -> new StraightLine(points));
    }

    @Test
    void 두_좌표_사이의_거리를_구하는지_테스트() {
        assertThat(straightLine.calculateArea()).isEqualTo(1.414, offset(0.00099));
    }

    @Test
    void 두_좌표의_기울기를_구하는지_테스트() {
        assertThat(straightLine.calculateSlope()).isEqualTo(1, offset(0.00099));
    }
}
