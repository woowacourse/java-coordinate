package coordinatecalculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CoordinateTest {
    @Test
    void 범위를_넘었을_경우() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Coordinate(0, 0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Coordinate(0, 25);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Coordinate(25, 0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Coordinate(25, 25);
        });
    }

    @Test
    void 두점사이_거리를_제대로_계산하는지_확인() {
        Coordinate coordinate = new Coordinate(5, 10);
        Coordinate coordinate1 = new Coordinate(10, 10);

        assertThat(coordinate.calculateDistance(coordinate1)).isEqualTo(5.0);
    }

    @Test
    void 기울기를_제대로_구하는지_테스트() {
        Coordinate coordinate = new Coordinate(5, 10);
        Coordinate coordinate1 = new Coordinate(10, 5);

        assertThat(coordinate.calculateSlope(coordinate1)).isEqualTo(1);
    }
}