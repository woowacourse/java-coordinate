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
    void 숫자가_0이하인_경우_예외처리_테스트() {
        assertThrows(IllegalArgumentException.class, () -> Coordinate.of(-1));
    }

    @Test
    void 숫자가_25이상인_경우_예외처리_테스트() {
        assertThrows(IllegalArgumentException.class, () -> Coordinate.of(25));
    }
}
