package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointsTest {
    @Test
    void 중복된_좌표가_있는_경우() {
        List<Point> points = Arrays.asList(new Point(1, 1), new Point(1, 1));
        assertThatThrownBy(() -> new Points(points)).isInstanceOf(IllegalArgumentException.class);
    }
}
