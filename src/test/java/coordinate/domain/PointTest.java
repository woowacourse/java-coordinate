package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PointTest {

    @Test
    public void Point클래스가_제대로_생성되는지() {
        Point point = Point.of(Integer.valueOf(0), Integer.valueOf(2));
        assertThat(point.getX()).isEqualTo(0);
        assertThat(point.getY()).isEqualTo(2);

        assertThat(point).isEqualTo(Point.of(Integer.valueOf(0), Integer.valueOf(2)));
    }

    @Test
    public void 입력범위를_벗어난_좌표를_생성할때_예외가_발생하는지() {
        Point.of(0, 0);
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Point.of(Integer.valueOf(0), Integer.valueOf(-1));
            Point.of(Integer.valueOf(-1), Integer.valueOf(0));
            Point.of(Integer.valueOf(0), Integer.valueOf(25));
            Point.of(Integer.valueOf(25), Integer.valueOf(0));
        });
    }
}
