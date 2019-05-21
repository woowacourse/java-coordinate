package coordinate;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointsTest {
    @Test
    void nullArgumentTest() {
        assertThrows(IllegalArgumentException.class, () -> new Points(null));
    }

    @Test
    void sortTest() {
        Points points = new Points(Arrays.asList(new Point(2, 0),
                new Point(1, 0), new Point(0, 0)));
        Points sortedPoints = new Points(Arrays.asList(new Point(0, 0),
                new Point(1, 0), new Point(2, 0)));
        points.sort();
        assertThat(points.get(0)).isEqualTo(sortedPoints.get(0));
        assertThat(points.get(1)).isEqualTo(sortedPoints.get(1));
        assertThat(points.get(2)).isEqualTo(sortedPoints.get(2));
    }

    @Test
    void invalidIndexTest() {
        Points points = new Points(Arrays.asList(new Point(0, 0)));
        assertThrows(IllegalArgumentException.class, () -> points.get(1));
    }

    @Test
    void getElementByIndexTest() {
        Points points = new Points(Arrays.asList(new Point(0, 0)));
        assertThat(points.get(0)).isEqualTo(new Point(0, 0));
    }
}
