package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointsGeneratorTest {
    @Test
    public void 문자열_패턴이_일치하지않으면_예외처리_테스트() {
        //assertThrows(IllegalArgumentException.class, () -> new ShapeGenerator("(10,11)-(19,20"));
        //assertThrows(IllegalArgumentException.class, () -> new ShapeGenerator("(10,11)(19,20)"));
        assertThrows(IllegalArgumentException.class, () -> new ShapeGenerator().create(PointsGenerator.generatePoints("(a,11)-(19,20)")));
    }

    @Test
    public void 좌표의_개수가_범위를_벗어났을_경우_예외처리_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new ShapeGenerator().create(PointsGenerator.generatePoints("(1,11)")));
    }
}
