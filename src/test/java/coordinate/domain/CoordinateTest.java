package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoordinateTest {
    @Test
    void 생성() {
        assertThat(Coordinate.of(10)).isEqualTo(Coordinate.of(10));
    }

    @Test
    void 숫자_범위_테스트() {
        assertThrows(IllegalArgumentException.class, () -> Coordinate.of(25));
    }
}
