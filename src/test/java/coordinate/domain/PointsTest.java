package coordinate.domain;

import coordinate.domain.generator.PointsGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointsTest {
    @Test
    void 중복된_점이_있는_경우_테스트() {
        assertThrows(IllegalArgumentException.class, () ->
                PointsGenerator.generatePoints("(10,10)-(22,10)-(22,18)-(10,10)"));
    }

    @Test
    void 점이_없을때_테스트() {
        assertThrows(IllegalArgumentException.class, () -> PointsGenerator.generatePoints(""));
    }
}
