package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class RectangleTest {
    @Test
    public void Point가_4개_미만_들어올_경우() {
        Vertices vertices = new Vertices(new ArrayList<>(Arrays.asList(new Point(1, 1), new Point(2, 2), new Point(3, 3))));

        assertThatThrownBy(() -> {
            new Rectangle(vertices);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void Point가_4개_이상_들어올_경우() {
        Vertices vertices = new Vertices(new ArrayList<>(Arrays.asList(new Point(1, 1),
                new Point(2, 2),
                new Point(3, 3),
                new Point(4, 4),
                new Point(5, 5))));


        assertThatThrownBy(() -> {
            new Rectangle(vertices);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 직사각형인지_확인() {
        Vertices vertices = new Vertices(new ArrayList<>(Arrays.asList(new Point(1, 1),
                new Point(2, 5),
                new Point(5, 1),
                new Point(5, 5))));

        assertThatThrownBy(() -> {
            new Rectangle(vertices);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 기울어진_직사각형_생성_확인() {
        Vertices vertices = new Vertices(new ArrayList<>(Arrays.asList(new Point(2, 1),
                new Point(1, 3),
                new Point(6, 3),
                new Point(5, 5))));

        assertThatCode(() -> {
            new Rectangle(vertices);
        }).doesNotThrowAnyException();
    }

    @Test
    public void 넓이를_잘_구하는지_확인() {
        Vertices vertices = new Vertices(new ArrayList<>(Arrays.asList(new Point(1, 1),
                new Point(1, 5),
                new Point(5, 1),
                new Point(5, 5))));

        Rectangle rectangle = new Rectangle(vertices);

        assertThat(rectangle.area()).isEqualTo(16);
    }

    @Test
    public void 넓이를_잘_구하는지_확인2() {
        Vertices vertices = new Vertices(new ArrayList<>(Arrays.asList(new Point(2, 1),
                new Point(1, 3),
                new Point(6, 3),
                new Point(5, 5))));

        Rectangle rectangle = new Rectangle(vertices);

        assertThat(rectangle.area()).isEqualTo(10);
    }
}
