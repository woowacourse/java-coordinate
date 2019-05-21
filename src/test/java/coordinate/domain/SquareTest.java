package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SquareTest {
    @Test
    void null_테스트() {
        assertThrows(NullPointerException.class, () -> new Square(null));
    }

    @Test
    void 사각형_점이_4개인지_테스트() {
        assertThrows(IllegalArgumentException.class, () ->
                new Square(Arrays.asList(new Point(1,2))));
    }

    @Test
    void 중복된_점이_있는_경우_테스트() {
        assertThrows(IllegalArgumentException.class, () ->
                new Square(Arrays.asList(new Point(1,2), new Point(1, 2),
                        new Point(2, 3), new Point(3,4))));
    }

    @Test
    void 직사각형_여부_테스트() {
        assertThrows(IllegalArgumentException.class, () ->
                new Square(Arrays.asList(new Point(1,2), new Point(4,5),
                        new Point(2, 3), new Point(3,4))));
    }
}
