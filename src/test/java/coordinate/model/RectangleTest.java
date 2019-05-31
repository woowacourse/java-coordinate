package coordinate.model;

import coordinate.model.creator.VerticesGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTest {
    @Test
    void 직사각형_생성_테스트() {
        Rectangle rect = new Rectangle(VerticesGenerator.makePoints("(0,0)-(0,2)-(3,2)-(3,0)"));
        assertThat(rect.equals(new Rectangle(VerticesGenerator.makePoints("(0,0)-(0,2)-(3,2)-(3,0)"))));
    }

    @Test
    void 정사각형_생성_테스트() {
        Rectangle rect = new Rectangle(VerticesGenerator.makePoints("(0,0)-(0,1)-(1,0)-(1,1)"));
        assertThat(rect.equals(new Rectangle(VerticesGenerator.makePoints("(0,0)-(0,1)-(1,0)-(1,1)"))));
    }

    @Test
    void 직사각형_검증_테스트() {
        assertThrows(IllegalArgumentException.class,
                ()-> new Rectangle(VerticesGenerator.makePoints("(1,1)-(2,2)-(3,3)-(4,4)")));
    }

    @Test
    void 넓이_계산_테스트() {
        Rectangle rect = new Rectangle(VerticesGenerator.makePoints("(0,0)-(3,2)-(0,2)-(3,0)"));
        assertThat(rect.getArea()).isEqualTo(6);
    }
}
