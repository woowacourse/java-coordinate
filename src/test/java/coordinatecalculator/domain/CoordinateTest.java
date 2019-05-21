package coordinatecalculator.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoordinateTest {

    @Test
    void 두점사이_거리를_제대로_계산하는지_확인() {
        Coordinate coordinate = new Coordinate(5, 10);
        Coordinate coordinate1 = new Coordinate(10, 10);

        assertThat(coordinate.calculate(coordinate1)).isEqualTo(5.0);
    }
}