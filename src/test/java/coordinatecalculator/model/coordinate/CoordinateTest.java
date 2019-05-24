package coordinatecalculator.model.coordinate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CoordinateTest {
    @Test
    void 좌표값_범위가_0에서_24사이인_경우() {
        assertDoesNotThrow(() -> new Coordinate(0, 24));
    }

    @Test
    void 좌표값_범위가_0미만인_경우() {
        assertThrows(IllegalArgumentException.class, () -> new Coordinate(-1, 24));
    }

    @Test
    void 좌표값_범위가_24초과인_경우() {
        assertThrows(IllegalArgumentException.class, () -> new Coordinate(0, 25));
    }
}
