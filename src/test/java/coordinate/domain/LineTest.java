package coordinate.domain;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class LineTest {

    @Test
    void length_() {
        Points points = Points.from(Arrays.asList(new Point(0, 0), new Point(1, 1)));
        Line line = Line.from(points);

        assertThat(line.length()).isEqualTo(1.414, offset(0.00099));
    }
}
