package coordinatecalculator.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class RectangleTest {


    @Test
    void 직사각형_맞는지_검증_테스트() {
        Points points = new Points("(1,1)-(1,3)-(2,1)-(2,3)".split("-"));
        assertDoesNotThrow(() -> new Rectangle(points));
    }

    @Test
    void 직사각형이_아닐때_검증_테스트() {
        Points points = new Points("(1,3)-(1,2)-(2,1)-(2,5)".split("-"));
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(points));
    }

    @Test
    void 직사각형_넓이_구하는_테스트() {
        Points points = new Points("(1,1)-(1,3)-(2,1)-(2,3)".split("-"));
        assertThat(new Rectangle(points).getArea()).isEqualTo(2);
    }

    @Test
    void 직사각형_대각선에_위치한_두_점_가져오기(){
        Points points = new Points("(1,1)-(1,3)-(2,1)-(2,3)".split("-"));

        List<Point> differPoints=new Rectangle(points).getDifferTwoPoints();
        assertTrue(differPoints.contains(new Point("(1,1)")));
        assertTrue(differPoints.contains(new Point("(2,3)")));
    }
}
