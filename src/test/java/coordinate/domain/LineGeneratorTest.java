package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineGeneratorTest {
    @Test
    void create() {
        Line line = new Line(new Point(10, 10), new Point(14, 15));

        assertThat(LineGenerator.generate("(10,10)-(14,15)"))
                .isEqualTo(line);
    }

    @Test
    void 잘못된_식인_경우() {
        assertThatThrownBy(() -> LineGenerator.generate("(10)-(14,15)")).isInstanceOf(IllegalArgumentException.class);
    }
}
