package coordinatecalculator.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class YTest {
    @Test
    void 좌표값_문자_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new Y("a"));
    }

    @Test
    void 좌표값_범위_초과() {
        assertThrows(IllegalArgumentException.class, () -> new Y("25"));
    }

    @Test
    void 좌표값_범위_미만() {
        assertThrows(IllegalArgumentException.class, () -> new Y("-1"));
    }
}
