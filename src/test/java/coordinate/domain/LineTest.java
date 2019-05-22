package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.offset;

public class LineTest {

    @Test
    void 거리_계산() {
        double expect = Math.sqrt(8);
        assertThat(new Line(Arrays.asList(new Point(0, 0), new Point(2, 2))).length())
                .isEqualTo(expect, offset(0.00099));
    }
}
