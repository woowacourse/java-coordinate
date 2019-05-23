package coordinatecalculator.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LineTest {
    @Test
    void 선_길이_구하기() {
        List<Coordinate> coordinates = Arrays.asList(new Coordinate(10, 13), new Coordinate(14, 10));
        assertThat(new Line(coordinates).calculateArea()).isEqualTo(5);
    }
}
