package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class PointsTest {
    private final List<Point> pointList = Arrays.asList(new Point(0, 0), new Point (1, 1));
    @Test
    void get_0() {
        Points points = Points.from(pointList);

        assertThat(points.get(0)).isEqualTo(points.get(0));
    }

    @Test
    void get_last() {
        Points points = Points.from(pointList);
        int idx = pointList.size() - 1;

        assertThat(points.get(idx)).isEqualTo(points.get(idx));
    }
}
