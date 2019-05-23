package coordinate;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TrinagleTest {

    @Test
    void 삼각형_생성_테스트() {
        Triangle tri = new Triangle(PointsGenerator.makePoints("(1,1)-(2,4)-(3,3)"));
        assertThat(tri).isEqualTo(new Triangle(PointsGenerator.makePoints("(1,1)-(2,4)-(3,3)")));
    }

    @Test
    void 삼각형_유효성_테스트() {
        assertThrows(IllegalArgumentException.class,
                ()-> new Triangle(PointsGenerator.makePoints("(1,1)-(2,2)-(3,3)")));
    }

}
