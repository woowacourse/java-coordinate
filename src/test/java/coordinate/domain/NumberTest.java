package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberTest {
    @Test
    void 하나의_숫자_생성지() {
        Number number = Number.create(10);
        assertThat(number).isEqualTo(Number.create(10));
    }

    @Test
    void 숫자가_음수일때() {
        assertThrows(IllegalArgumentException.class, () -> Number.create(-1));
    }

    @Test
    void 숫자가_24를_넘을때() {
        assertThrows(IllegalArgumentException.class, () -> Number.create(25));
    }

    @Test
    void 뺄셈계산() {
        Number number1 = Number.create(3);
        Number number2 = Number.create(5);

        assertThat(number1.subtract(number2)).isEqualTo(-2);
    }
}
