package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShapeGeneratorTest {

    @Test
    void 문자열_패턴이_일치하지않으면_예외처리_테스트() {
        //assertThrows(IllegalArgumentException.class, () -> new ShapeGenerator("(10,11)-(19,20"));
        //assertThrows(IllegalArgumentException.class, () -> new ShapeGenerator("(10,11)(19,20)"));
        assertThrows(IllegalArgumentException.class, () -> new ShapeGenerator("(a,11)-(19,20)"));
    }

    @Test
    void 두_개의_좌표가_입력됐을_때_Line을_리턴하는_테스트() {
        Point pointA = new Point(new Coordinate(10), new Coordinate(10));
        Point pointB = new Point(new Coordinate(14), new Coordinate(15));
        Line line = new Line(pointA, pointB);
        ShapeGenerator shapeGenerator = new ShapeGenerator("(10,10)-(14,15)");
        assertThat(shapeGenerator.generateLine()).isEqualTo(line);
    }
}
