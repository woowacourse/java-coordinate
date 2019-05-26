package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RectangleTest {

    @Test
    void 입력이_사다리꼴() {
        Points points = new Points(Arrays.asList(new Point(0,0),new Point(3,5),new Point(7,5),new Point(10,10)));
        assertThatIllegalArgumentException().isThrownBy(() ->{
            new Rectangle(points);
        });
    }

    @Test
    void 입력이_마름모() {
        Points points = new Points(Arrays.asList(new Point(0,1),new Point(2,0),new Point(4,1),new Point(2,2)));
        assertThatIllegalArgumentException().isThrownBy(() ->{
            new Rectangle(points);
        });
    }

    @Test
    void 점들이_같은_선일때() {
        Points points = new Points(Arrays.asList(new Point(1,0),new Point(2,0),new Point(3,0),new Point(4,0)));
        assertThatIllegalArgumentException().isThrownBy(() ->{
            new Rectangle(points);
        });
    }

    @Test
    void 넓이구하는_테스트() {
        Points points = new Points(Arrays.asList(new Point(0,0),new Point(10,0),new Point(0,10),new Point(10,10)));
        assertThat(new Rectangle(points).calculateArea()).isEqualTo(100);
    }
}
