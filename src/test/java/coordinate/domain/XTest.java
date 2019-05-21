package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class XTest {
    @Test
    void 생성() {
        assertThat(new X(10)).isEqualTo(new X(10));
    }

    @Test
    void 숫자_범위_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new X(25));
    }
}
