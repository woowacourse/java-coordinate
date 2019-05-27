package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StraightLineTest {
    @Test
    void 겹쳐진_두_좌표를_넘겨받았을_때_생성자에서_예외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () ->
                new StraightLine(Arrays.asList(new Point(Arrays.asList(3, 4)), new Point(Arrays.asList(3, 4)))));
    }

    @Test
    void 좌표가_두개가_아닐때_예외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new StraightLine(Arrays.asList(new Point(Arrays.asList(3, 4)))));
    }

    @Test
    void 두_좌표_사이의_거리를_구하는지_테스트() {
        StraightLine straightLine = new StraightLine(Arrays.asList(new Point(Arrays.asList(3, 3)), new Point(Arrays.asList(4, 4))));
        assertThat(straightLine.calculateArea()).isEqualTo(1.414, offset(0.00099));
    }

    @Test
    void 두_좌표의_기울기를_구하는지_테스트() {
        StraightLine straightLine = new StraightLine(Arrays.asList(new Point(Arrays.asList(3, 3)), new Point(Arrays.asList(4, 4))));
        assertThat(straightLine.calculateSlope()).isEqualTo(1, offset(0.00099));
    }
}
