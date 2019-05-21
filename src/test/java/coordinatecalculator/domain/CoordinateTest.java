package coordinatecalculator.domain;

import coordinatecalculator.domain.Coordinate;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoordinateTest {

    @Test
    void 두점사이_거리를_제대로_계산하는지_확인() {
        Coordinate coordinate = new Coordinate(5,10);
        assertThat(coordinate.calculate(10,10)).isEqualTo(5.0);
    }
}