package coordinate.domain;

import coordinate.domain.generator.PointsGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class LinesTest {
    @Test
    void 길이_테스트() {
        List<Line> lineList = Arrays.asList(new Line(new PointsGenerator("(10,10)-(14,15)").generate()));
        Lines lines = new Lines(lineList);

        assertThat(lines.lengths().get(0)).isEqualTo(6.403124, offset(0.00009));
    }
}