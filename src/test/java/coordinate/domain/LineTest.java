package coordinate.domain;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class LineTest {

    @Test
    void length_() {
        Line line = new Line(Arrays.asList(new Point(0, 0), new Point(1, 1)));

        assertThat(line.length()).isEqualTo(1.414, offset(0.00099));
    }
}
