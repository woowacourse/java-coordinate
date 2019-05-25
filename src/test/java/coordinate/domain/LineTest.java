package coordinate.domain;

import coordinate.domain.generator.PointsGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineTest {

    @Test
    void 거리_테스트() {
        double expect = Math.sqrt(8);
        assertThat(new Line(new PointsGenerator("(0,0)-(2,2)").generate()).area())
                .isEqualTo(expect, offset(0.00099));
    }

    @Test
    void 사이즈_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Line(new PointsGenerator("(0,0)").generate()));
    }
}
