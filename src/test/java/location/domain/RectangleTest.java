package location.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {
    @Test
    void 마름모() {
        assertThrows(IllegalArgumentException.class,
                () -> new Rectangle(new Point(5, 3), new Point(10, 5), new Point(15, 3), new Point(20, 5)));
    }

    @Test
    void 사다리꼴() {
        assertThrows(IllegalArgumentException.class,
                () -> new Rectangle(new Point(5, 10), new Point(7, 20), new Point(10, 20), new Point(13, 10)));
    }

    @Test
    void 정상적인_직사각형() {
        Rectangle rectangle = new Rectangle(new Point(0, 1), new Point(1, 0), new Point(2, 3), new Point(3, 2));
        assertThat(rectangle);
    }

    @Test
    void 넓이() {
        Rectangle rectangle = new Rectangle(new Point(0, 1), new Point(1, 0), new Point(2, 3), new Point(3, 2));
        assertThat(rectangle.calculateArea()).isEqualTo(4, Assertions.offset(0.009));
    }
}
