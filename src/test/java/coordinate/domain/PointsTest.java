package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointsTest {
    @Test
    void 중복된_좌표가_있는_경우() {
        List<Point> points = Arrays.asList(new Point(1, 1), new Point(1, 1));

        assertThatThrownBy(() -> new Points(points)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복되지_않은_X좌표의_개수_확인() {
        List<Point> points = Arrays.asList(
                new Point(1, 3),
                new Point(2, 3),
                new Point(1, 4),
                new Point(2, 1));

        assertThat(new Points(points).getNonDuplicateXSize()).isEqualTo(2);
    }

    @Test
    void 중복되지_않은_Y좌표의_개수_확인() {
        List<Point> points = Arrays.asList(
                new Point(1, 4),
                new Point(2, 3),
                new Point(1, 3),
                new Point(2, 1));

        assertThat(new Points(points).getNonDuplicateYSize()).isEqualTo(3);
    }
}
