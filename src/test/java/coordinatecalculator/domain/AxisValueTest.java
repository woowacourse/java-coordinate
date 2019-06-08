package coordinatecalculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AxisValueTest {
    @Test
    void AxisValue객체가_재사용되는지_확인() {
        for (int i = 1; i <= 24; i++) {
            assertThat(AxisValue.getInstance(i + "") == AxisValue.getInstance(i + "")).isTrue();
        }
    }

    @Test
    void 좌표값_문자_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> AxisValue.getInstance("a"));
    }

    @Test
    void 좌표값_범위_초과() {
        assertThrows(IllegalArgumentException.class, () -> AxisValue.getInstance("25"));
    }

    @Test
    void 좌표값_범위_미만() {
        assertThrows(IllegalArgumentException.class, () -> AxisValue.getInstance("0"));
    }
}
