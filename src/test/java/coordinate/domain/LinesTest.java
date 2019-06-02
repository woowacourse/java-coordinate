package coordinate.domain;

import coordinate.domain.generator.PointsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class LinesTest {
    Lines lines;

    @BeforeEach
    void setUp() {
        Line line1 = new Line(PointsGenerator.generatePoints("(10,10)-(14,15)"));
        Line line2 = new Line(PointsGenerator.generatePoints("(20,8)-(14,15)"));
        Line line3 = new Line(PointsGenerator.generatePoints("(10,10)-(20,8)"));
        List<Line> lineList = Arrays.asList(line1, line2, line3);
        lines = new Lines(lineList);
    }

    @Test
    void 첫번째_선_길이_루트_41_인지_테스트() {
        assertThat(lines.lengths().get(0)).isEqualTo(6.403124, offset(0.00009));
    }

    @Test
    void 두번째_선_길이_루트_85_인지_테스트() {
        assertThat(lines.lengths().get(1)).isEqualTo(9.219544, offset(0.00009));
    }

    @Test
    void 마지막_선_길이_루트_104_인지_테스트() {
        assertThat(lines.lengths().get(2)).isEqualTo(10.198039, offset(0.00009));
    }
}