package coordinate.domain;

import coordinate.domain.generator.PointsGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointsTest {
    @Test
    void 중복_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            Points points = new PointsGenerator("(10,10)-(22,10)-(22,18)-(10,10)").generate();
        });
    }

    @Test
    void 점이_없을때_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            Points points = new PointsGenerator("").generate();
        });
    }
}
