package coordinate.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValueTest {
    @Test
    void 유효한_값_검증_25_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Value(25));
    }

    @Test
    void 유효한_값_검증_음수_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Value(-1));
    }
}
