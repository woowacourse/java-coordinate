package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {
    @Test
    void x좌표가_24를_넘어가는_경우() {
        assertThatThrownBy(() -> new Point(25, 1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void y좌표가_24를_넘어가는_경우() {
        assertThatThrownBy(() -> new Point(1, 25)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void x좌표가_0보다_작은_경우() {
        assertThatThrownBy(() -> new Point(0, 3)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void y좌표가_0보다_작은_경우() {
        assertThatThrownBy(() -> new Point(2, 0)).isInstanceOf(IllegalArgumentException.class);
    }
}
