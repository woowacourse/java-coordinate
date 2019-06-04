package coordinate.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PointsTest {

    private Points points;

    @BeforeEach
    void setUp() {
        points = Points.create();
        points.addPoint(Point.create(10, 10));
        points.addPoint(Point.create(22, 10));
        points.addPoint(Point.create(22, 18));
        points.addPoint(Point.create(10, 18));
    }

    @Test
    void 포인트가_널일때() {
        assertThrows(NullPointerException.class, () -> {
            new Points(null);
        });
    }

    @Test
    void 좌표가_중복될때() {
        Point point = Point.create(10, 10);

        assertThrows(IllegalArgumentException.class, () -> {
            points.addPoint(point);
        });
    }

    @Test
    void 좌표의_갯수() {
        assertThat(points.getSize()).isEqualTo(4);
    }

    @Test
    void x좌표의_같은_값이_두개일때() {
        assertThat(points.check("x")).isTrue();
    }

    @Test
    void y좌표의_같은_값이_두개일때() {
        assertThat(points.check("y")).isTrue();
    }
}
