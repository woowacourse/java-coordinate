package coordinatecalculator.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class LineTest {

    @Test
    void 선의_길이를_제대로_구하는지_테스트() {
        /* Given */
        Coordinates coordinates = new Coordinates(Arrays.asList(new Coordinate(2, 20), new Coordinate(20, 20)),
                2);

        /* Then */
        assertThat(new Line(coordinates).getLineLength()).isEqualTo(18, offset(0.00099));
    }
}