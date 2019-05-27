package coordinate.domain.point;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class PointGroupTest {

    PointGroup points;

    @BeforeEach
    void setup() {
        List<Point> points = Arrays.asList(
                Point.create(1, 1),
                Point.create(4, 1),
                Point.create(4, 3),
                Point.create(1, 3)
        );

        this.points = new PointGroup(points);
    }
    @Test
    void size() {
        assertThat(points.size()).isEqualTo(4);
    }

    @Test
    void getSquaredDistances() {
        assertThat(points.getSquaredDistanceOf(0, 0)).isEqualTo(0);
        assertThat(points.getSquaredDistanceOf(0, 1)).isEqualTo(4);
    }

    @Test
    void have1() {
        assertThat(points.have(Point.create(1,1))).isTrue();
    }

    @Test
    void have2() {
        assertThat(points.have(Point.create(0,0))).isFalse();
    }
}