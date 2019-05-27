package coordinate.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointsTest {

    Points points;

    @BeforeEach
    void setUp() {
        Points points = Points.create();
        points.addPoint(Point.create(10, 10));
        points.addPoint(Point.create(22, 10));
        points.addPoint(Point.create(22, 18));
        points.addPoint(Point.create(10, 18));
    }

    @Test
    void 첫번째_변의_거리() {
        assertThat(points.getFirstDistance()).isEqualTo(8);
    }

    @Test
    void 두번째_변의_거리() {
        assertThat(points.getSecondDistance()).isEqualTo(12);
    }

    @Test
    void x가_같은지_확인() {
        assertThat(points.isNotEqualX(3)).isFalse();
    }

    @Test
    void y가_같은지_확인() {
        assertThat(points.isNotEqualY(1)).isFalse();
    }

    @Test
    void x좌표가_2개이상_위치에_있는지() {
        assertThat(points.checkX()).isTrue();
    }
}
