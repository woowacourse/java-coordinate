package coordinate.domain.Coordinate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class XCoordinateTest {
    @Test
    void X좌표정상생성() {
        assertDoesNotThrow(() -> {
            new XCoordinate(24);
        });
    }

    @Test
    void X좌표생성오류1() {
        assertThrows(IllegalArgumentException.class, () -> {
            new XCoordinate(25);
        });
    }

    @Test
    void X좌표생성오류2() {
        assertThrows(IllegalArgumentException.class, () -> {
            new XCoordinate(-1);
        });
    }
}
