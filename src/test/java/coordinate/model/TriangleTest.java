package coordinate.model;

import coordinate.model.creator.VerticesGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.offset;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleTest {

    @Test
    void 삼각형_생성_테스트() {
        Triangle tri = new Triangle(VerticesGenerator.makePoints("(1,1)-(2,4)-(3,3)"));
        assertThat(tri.equals(new Triangle(VerticesGenerator.makePoints("(1,1)-(2,4)-(3,3)"))));
    }

    @Test
    void 삼각형_유효성_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Triangle(VerticesGenerator.makePoints("(1,1)-(1,1)-(1,1)")));
    }

    @Test
    void 삼각형_넓이_테스트() {
        Triangle tri = new Triangle(VerticesGenerator.makePoints("(0,0)-(4,0)-(0,4)"));
        assertThat(tri.getArea()).isEqualTo(8, offset(0.00099));
    }
}
