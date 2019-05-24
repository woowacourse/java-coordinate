package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CoordinateContainerTest {

    @Test
    public void CoordinateContainer에서_인덱스에_맞는_Coordinate_객제를_맞게_꺼내는지_테스트() {
        assertThat(CoordinateContainer.get(1)).isEqualTo(new Coordinate(1));
    }

    @Test
    public void CoordinateContainer에서_범위에_벗어난_좌표를_꺼낼_때_예외처리_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
           CoordinateContainer.get(25);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            CoordinateContainer.get(-1);
        });
    }
}