package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PointListTest {

    @Test
    void 중복좌표테스트() {
        assertThatIllegalArgumentException().isThrownBy(() ->{
            new PointList(PointFactory.generateCoordinateList(Arrays.asList("0,0","0,0","7,5","10,0")));
        });
    }
    //TODO
    @Test
    void 길이구하기() {
        PointList points = new PointList(Arrays.asList(new Point("10","10"),new Point("10","18"),new Point("22","18"),new Point("22","10")));
        List<Line> lines = points.findLine();
        assertEquals(lines,Arrays.asList(new Line(Arrays.asList(new Point("10","18")))));
    }
}
