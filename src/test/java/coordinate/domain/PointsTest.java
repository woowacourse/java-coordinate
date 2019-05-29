package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;


public class PointsTest {
    private final List<Point> pointList = Arrays.asList(new Point(0, 0), new Point (1, 1));
    private final Points points = Points.from(pointList);

    @Test
    void get_0() {
        assertThat(points.get(0)).isEqualTo(points.get(0));
    }

    @Test
    void get_last() {
        int idx = pointList.size() - 1;

        assertThat(points.get(idx)).isEqualTo(points.get(idx));
    }

    @Test
    void size() {
        assertThat(points.size()).isEqualTo(pointList.size());
    }

    @Test
    void distance() {
        assertThat(points.distance(0, 1)).isEqualTo(1.414, offset(0.00099));
    }
}
