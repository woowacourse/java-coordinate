package coordinate.domain;

import coordinate.domain.generator.PointsGenerator;
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
                new Square(new PointsGenerator("(10,10)-(22,10)-(22,18)").generate()));
    }

    @Test
    void 직사각형_여부_테스트() {
        assertThrows(IllegalArgumentException.class, () ->
                new Square(new PointsGenerator("(10,10)-(22,10)-(22,18)-(10,1000)").generate()));
    }
}
