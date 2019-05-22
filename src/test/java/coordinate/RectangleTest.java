package coordinate;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;




public class RectangleTest {
    @Test
    void 직사각형_판별_테스트() {
        Rectangle rect = new Rectangle(PointsGenerator.makePoints("(0,0)-(0,1)-(1,0)-(1,1)"));
        assertThat(rect).isEqualTo(new Rectangle(PointsGenerator.makePoints("(0,0)-(0,1)-(1,0)-(1,1)")));
    }
}
