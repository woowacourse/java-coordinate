package location.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointTest {

    @Test
    void 좌표_24_초과_일때() {
        assertThrows(IllegalArgumentException.class, () -> new Point(25, 25));
    }

    @Test
    void 음수일때() {
        assertThrows(IllegalArgumentException.class, () -> new Point(-1, -1));
    }
}
