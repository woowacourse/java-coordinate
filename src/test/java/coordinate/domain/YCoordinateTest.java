package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class YCoordinateTest {
    @Test
    void 최댓값_초과의_값을_입력했을경우() {
        assertThrows(IllegalArgumentException.class, () -> YCoordinate.of(25));
    }

    @Test
    void 최댓값_미만의_값을_입력했을경우() {
        assertThrows(IllegalArgumentException.class, () -> YCoordinate.of(0));
    }
}