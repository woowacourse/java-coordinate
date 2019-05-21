package coordinatecalculator.util;

import coordinatecalculator.domain.Point;
import coordinatecalculator.domain.Points;
import org.junit.jupiter.api.Test;


import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PointsGeneratorTest {
    @Test
    void 잘_나눠지는지_확인() {
        String input = "(10,10)-(20,20)";
        assertThat(PointsGenerator.create(input)).isEqualTo(new Points(Arrays.asList(new Point("10", "10"), new Point("20", "20"))));
    }
}
