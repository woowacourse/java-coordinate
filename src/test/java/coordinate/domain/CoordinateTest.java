package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoordinateTest {
    @Test
    public void CoordinateContainer에서_범위에_벗어난_좌표를_꺼낼_때_예외처리_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            Coordinate.get(25);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Coordinate.get(-1);
        });
    }
}
