package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {
    @Test
    public void 범위_안의_값이_입력된_경우() {
        assertThatCode(() -> {
            new Point(1, 1);
        }).doesNotThrowAnyException();
    }

    @Test
    public void x값이_범위를_벗어난_경우() {
        assertThatThrownBy(() -> {
            new Point(100, 1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void y값이_범위를_벗어난_경우() {
        assertThatThrownBy(() -> {
            new Point(1, 100);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
