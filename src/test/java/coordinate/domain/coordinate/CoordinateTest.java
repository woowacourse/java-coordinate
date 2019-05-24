package coordinate.domain.coordinate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoordinateTest {
    @Test
    void X좌표정상생성() {
        assertDoesNotThrow(() -> {
            new Coordinate(24);
        });
    }

    @Test
    void 제한초과좌표() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Coordinate(25);
        });
    }

    @Test
    void 제한미달좌표() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Coordinate(-1);
        });
    }
}
