package coordinate.domain.point;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CoordinateTest {
    @Test
    void 좌표정상생성() {
        assertDoesNotThrow(() -> {
            new Coordinate(24);
        });
    }

    @Test
    void 좌표생성오류1() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Coordinate(25);
        });
    }

    @Test
    void 좌표생성오류2() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Coordinate(-1);
        });
    }

    @Test
    void 좌표간_거리() {
        assertThat(new Coordinate(3).differenceFrom(new Coordinate(5))).isEqualTo(2);
    }
}