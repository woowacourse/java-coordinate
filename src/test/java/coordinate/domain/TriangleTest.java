package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleTest {
    @Test
    void 겹쳐진_두_좌표를_넘겨받았을_때_생성자에서_예외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(Arrays.asList(
                new Point(Arrays.asList(3, 4)), new Point(Arrays.asList(3, 4)),
                new Point(Arrays.asList(3, 6)))));
    }

    @Test
    void 좌표가_세개가_아닐때_예외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(Arrays.asList(
                new Point(Arrays.asList(3, 4)), new Point(Arrays.asList(3, 6)))));
    }

    @Test
    void 한_직선에의_세개의_좌표가_있을때_예외를_던지는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(Arrays.asList(
                new Point(Arrays.asList(3, 4)), new Point(Arrays.asList(3, 5)),
                new Point(Arrays.asList(3, 6)))));
    }

    @Test
    void 넓이를_구하는지_테스트() {
        Triangle triangle = new Triangle(Arrays.asList(
                new Point(Arrays.asList(3, 3)), new Point(Arrays.asList(7, 3)),
                new Point(Arrays.asList(3, 6))));
        assertThat(triangle.calculateArea()).isEqualTo(6, offset(0.00099));
    }
}