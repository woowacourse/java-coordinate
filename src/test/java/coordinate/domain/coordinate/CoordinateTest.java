package coordinate.domain.coordinate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoordinateTest {
    @Test
    void 좌표정상생성() {
        assertDoesNotThrow(() -> {
            Coordinate.create(24);
        });
    }

    @Test
    void 제한초과좌표() {
        assertThrows(IllegalArgumentException.class, () -> {
            Coordinate.create(25);
        });
    }

    @Test
    void 제한미달좌표() {
        assertThrows(IllegalArgumentException.class, () -> {
            Coordinate.create(-1);
        });
    }
}
