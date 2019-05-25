package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class XTest {
    @Test
    void x좌표가_24를_넘어가는_경우() {
        assertThatThrownBy(() -> new X(25)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void x좌표가_0보다_작은_경우() {
        assertThatThrownBy(() -> new X(0)).isInstanceOf(IllegalArgumentException.class);
    }
}
