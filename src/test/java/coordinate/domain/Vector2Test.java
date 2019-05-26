package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class Vector2Test {

    @Test
    void dotProduct_양수() {
        Vector2 a = Vector2.of(10, 5);
        Vector2 b = Vector2.of(2, 3);

        assertThat(a.doProduct(b)).isEqualTo(20 + 15);
    }

    @Test
    void dotProduct_음수() {
        Vector2 a = Vector2.of(10, 5);
        Vector2 b = Vector2.of(-2, 3);

        assertThat(a.doProduct(b)).isEqualTo(-20 + 15);
    }

    @Test
    void length_0() {
        assertThat(Vector2.of(0, 0).length()).isEqualTo(0.0, offset(0.00099));
    }

    @Test
    void length_() {
        assertThat(Vector2.of(1, 1).length()).isEqualTo(1.414, offset(0.00099));
    }
}
