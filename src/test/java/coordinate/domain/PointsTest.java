package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointsTest {
    @Test
    void first() {
        Points points = Points.create();
        points.addPoint(Point.create(10,10));
        points.addPoint(Point.create(22,10));
        points.addPoint(Point.create(22,18));
        points.addPoint(Point.create(10,18));

        assertThat(points.getFirstDistance()).isEqualTo(8);
    }

    @Test
    void secone() {
        Points points = Points.create();
        points.addPoint(Point.create(10,10));
        points.addPoint(Point.create(22,10));
        points.addPoint(Point.create(22,18));
        points.addPoint(Point.create(10,18));

        assertThat(points.getSecondDistance()).isEqualTo(12);
    }

    @Test
    void x가_같은지_확인() {
        Points points = Points.create();
        points.addPoint(Point.create(10,10));
        points.addPoint(Point.create(22,10));
        points.addPoint(Point.create(22,18));
        points.addPoint(Point.create(10,18));

        assertThat(points.isNotEqualX(3)).isFalse();
    }

 /*   @Test
    void y가_같은지_확인() {
        Points points = Points.create();
        points.addPoint(Point.create(10,10));
        points.addPoint(Point.create(22,10));
        points.addPoint(Point.create(22,18));
        points.addPoint(Point.create(10,18));

        assertThat(points.isNotEqualY(1)).isFalse();
    }*/
}
