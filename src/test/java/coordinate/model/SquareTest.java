package coordinate.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SquareTest {
    @Test
    void 사각형_생성_검사() {
        assertThrows(IllegalArgumentException.class, () -> {
            Point p1 = new Point(1, 1);
            Point p2 = new Point(1, 1);
            Point p3 = new Point(1, 3);
            Point p4 = new Point(4, 4);
            new Square(Arrays.asList(p1, p2, p3, p4));
        });
    }

    @Test
    void 사각형_뒤틀림_검사() {
        assertThrows(IllegalArgumentException.class, () -> {
            Point p1 = new Point(1, 1);
            Point p2 = new Point(3, 1);
            Point p3 = new Point(1, 3);
            Point p4 = new Point(4, 4);
            new Square(Arrays.asList(p1, p2, p3, p4));
        });
    }

    @Test
    void 사각형_넓이_계산() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(3, 1);
        Point p3 = new Point(1, 3);
        Point p4 = new Point(3, 3);
        assertThat((new Square(Arrays.asList(p1, p2, p3, p4)).getScore())).isEqualTo(4, offset(0.00099));
    }
}
