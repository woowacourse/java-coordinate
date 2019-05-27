package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class PointTest {
    @Test
    void 두_좌표의_값을_가지고_있는_Point_생성() {
        Point point = Point.create(1, 0);
        assertThat(point).isEqualTo(Point.create(1, 0));
    }

    @Test
    void 거리계산() {
        Point point1 = Point.create(10, 10);
        Point point2 = Point.create(14, 15);

        assertThat(point1.getDistance(point2)).isEqualTo(6.403124, offset(0.00099));
    }

    @Test
    void x가_같은지_확인() {
        Point point1 = Point.create(10, 11);
        Point point2 = Point.create(10, 12);

        assertThat(point1.isEqualX(point2)).isTrue();
    }

    @Test
    void y가_같은지_확인() {
        Point point1 = Point.create(10, 12);
        Point point2 = Point.create(11, 12);

        assertThat(point1.isEqualY(point2)).isTrue();
    }
}
