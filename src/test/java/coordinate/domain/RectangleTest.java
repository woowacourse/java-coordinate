package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTest {
    @Test
    void 겹쳐진_두_좌표를_넘겨받았을_때_생성자에서_예외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(Arrays.asList(
                new Point(3, 4), new Point(3, 4),
                new Point(3, 6), new Point(4, 6))));
    }

    @Test
    void 좌표가_네개가_아닐때_예외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(Arrays.asList(
                new Point(3, 4), new Point(3, 6), new Point(6, 6))));
    }

    @Test
    void 한_직선에_세개_이상의_좌표가_있을때_예외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(Arrays.asList(
                new Point(3, 4), new Point(3, 5),
                new Point(3, 6), new Point(6, 6))));
    }

    @Test
    void 직사각형이_아닌_경우_예외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(Arrays.asList(
                new Point(3, 4), new Point(3, 5),
                new Point(4, 4), new Point(4, 6))));
    }

    @Test
    void 넓이를_구하는지_테스트() {
        Rectangle rectangle = new Rectangle(Arrays.asList(
                new Point(3, 4), new Point(3, 5),
                new Point(4, 4), new Point(4, 5)));
        assertThat(rectangle.calculateArea()).isEqualTo(1, offset(0.00099));
    }
}