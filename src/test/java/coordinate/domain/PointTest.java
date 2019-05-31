package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PointTest {

    @Test
    public void Point클래스가_제대로_생성되는지() {
        Point point = Point.of(0, 1);
        assertThat(point).isEqualTo(Point.of(0, 1));
    }

    @Test
    public void 입력범위를_벗어난_좌표를_생성할때_예외가_발생하는지() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Point.of(0, -1);
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Point.of(-1, 0);
        });
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            Point.of(0, 25);
        });
    }
}
