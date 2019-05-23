package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class SquareTest {

    @Test
    void 입력이_사다리꼴() {
        PointList points = new PointList(PointFactory.generateCoordinateList(Arrays.asList("0,0","3,5","7,5","10,0")));
        assertThatIllegalArgumentException().isThrownBy(() ->{
            new Square(points.findLine());
        });
    }

    @Test
    void 입력이_마름모() {
        PointList points = new PointList(PointFactory.generateCoordinateList(Arrays.asList("0,1","2,0","4,1","2,2")));
        assertThatIllegalArgumentException().isThrownBy(() ->{
            new Square(points.findLine());
        });
    }

    @Test
    void 점들이_같은_선일때() {
        PointList points = new PointList(PointFactory.generateCoordinateList(Arrays.asList("1,0","2,0","3,0","4,0")));
        assertThatIllegalArgumentException().isThrownBy(() ->{
            new Square(points.findLine());
        });
    }

    @Test
    void 넓이구하는_테스트() {
        PointList points = new PointList(PointFactory.generateCoordinateList(Arrays.asList("0,0","10,0","0,10","10,10")));
        Square square = new Square(points.findLine());
        assertThat(square.findArea()).isEqualTo(100);
    }
}
