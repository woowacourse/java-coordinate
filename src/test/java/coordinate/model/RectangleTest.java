package coordinate.model;

import coordinate.model.creator.PointsGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class RectangleTest {
    @Test
    void 직사각형_생성_테스트() {
        Rectangle rect = new Rectangle(PointsGenerator.makePoints("(0,0)-(0,2)-(3,2)-(3,0)"));
        assertThat(rect).isEqualTo(new Rectangle(PointsGenerator.makePoints("(0,0)-(0,2)-(3,2)-(3,0)")));
    }

    @Test
    void 정사각형_생성_테스트() {
        Rectangle rect = new Rectangle(PointsGenerator.makePoints("(0,0)-(0,1)-(1,0)-(1,1)"));
        assertThat(rect).isEqualTo(new Rectangle(PointsGenerator.makePoints("(0,0)-(0,1)-(1,0)-(1,1)")));
    }

    @Test
    void 직사각형_검증_테스트() {
        assertThrows(IllegalArgumentException.class,
                ()-> new Rectangle(PointsGenerator.makePoints("(1,1)-(2,2)-(3,3)-(4,4)")));
    }

    @Test
    void 넓이_계산_테스트() {
        Rectangle rect = new Rectangle(PointsGenerator.makePoints("(0,0)-(3,2)-(0,2)-(3,0)"));
        assertThat(rect.area()).isEqualTo(6);
    }
}
