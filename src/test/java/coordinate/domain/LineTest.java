package coordinate.domain;

import coordinate.domain.generator.PointsGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LineTest {

    @Test
    void 거리가_루트_8인_선_길이_테스트() {
        double expect = Math.sqrt(8);
        assertThat(new Line(PointsGenerator.generatePoints("(0,0)-(2,2)")).length())
                .isEqualTo(expect, offset(0.00099));
    }

    @Test
    void 점이_한개인_경우_예외처리_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Line(PointsGenerator.generatePoints("(0,0)")));
    }
}
