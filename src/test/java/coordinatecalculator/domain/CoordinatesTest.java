package coordinatecalculator.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CoordinatesTest {
    @Test
    void 중복되는_좌표가_있으면_예외를_던지는지_테스트() {
        /* Then */
        assertThrows(IllegalArgumentException.class, () -> {
            new Coordinates(Arrays.asList(new Coordinate(2, 3), new Coordinate(2, 3)), 2);
        });
    }

    @Test
    void 두_점사이의_거리를_제대로_구하는지_테스트() {
        /* Given */
        Coordinates coordinates = new Coordinates(Arrays.asList(new Coordinate(2, 2), new Coordinate(2, 4)), 2);
        /* Then */
        assertThat(coordinates.getDistanceBetweenTwoPoints(0, 1)).isEqualTo(2, offset(0.00999));
    }

    @Test
    void 두_점사이의_기울기를_제대로_구하는지_테스트() {
        /* Given */
        Coordinates coordinates = new Coordinates(Arrays.asList(new Coordinate(2, 2), new Coordinate(4, 4)), 2);
        /* Then */
        assertThat(coordinates.getSlopeBetweenTwoPoints(0, 1)).isEqualTo(1, offset(0.00999));
    }
}