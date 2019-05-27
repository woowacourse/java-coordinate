package coordinatecalculator.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class XTest {
    @Test
    void 좌표값_문자_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new X("a"));
    }

    @Test
    void 좌표값_범위_초과() {
        assertThrows(IllegalArgumentException.class, () -> new X("25"));
    }

    @Test
    void 좌표값_범위_미만() {
        assertThrows(IllegalArgumentException.class, () -> new X("-1"));
    }
}
