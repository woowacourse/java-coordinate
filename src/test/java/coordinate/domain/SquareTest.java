package coordinate.domain;

import coordinate.domain.generator.PointsGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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
                new Square(new PointsGenerator("(10,10)-(22,10)-(22,18)-(10,3)").generate()));
    }

    @Test
    void 면적_테스트() {
        Square square = new Square(new PointsGenerator("(10,10)-(22,10)-(22,18)-(10,18)").generate());
        assertThat(square.area()).isEqualTo(96);
    }
}
