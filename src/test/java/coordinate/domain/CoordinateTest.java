package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoordinateTest {

    @Test
    public void 좌표가_0과24_사이가_아니면_예외처리() {
        assertThrows(IllegalArgumentException.class, () -> new Coordinate(30));
    }
}
