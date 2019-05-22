package coordinatecalculator.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LineTest {
    @Test
    void 선_길이_구하기() {
        assertThat(new Line(new Coordinate(10, 13), new Coordinate(14, 10)).getLength()).isEqualTo(5);
    }
}
