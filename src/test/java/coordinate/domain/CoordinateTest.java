package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CoordinateTest {
    @Test
    void x좌표가_24를_넘어가는_경우() {
        assertThatThrownBy(() -> new Coordinate(25)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void x좌표가_0보다_작은_경우() {
        assertThatThrownBy(() -> new Coordinate(0)).isInstanceOf(IllegalArgumentException.class);
    }
}
