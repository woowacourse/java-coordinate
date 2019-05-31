package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class AbstractPointParserTest {
    private final PointsFactory factory = PointsFactory.from(DefaultPoint::new);

    @Test
    void parse_Point_1개() {
        Points points = Points.from(Arrays.asList(
                DefaultPoint.ofInts(0, 0)
        ));

        assertThat(PointParser.parse("(0,0)", factory)).isEqualTo(points);
    }

    @Test
    void parse_Point_2개() {
        Points points = Points.from(Arrays.asList(
                DefaultPoint.ofInts(0, 2),
                DefaultPoint.ofInts(4, 6)
        ));

        assertThat(PointParser.parse("(0,2)-(4,6)", factory)).isEqualTo(points);
    }
}