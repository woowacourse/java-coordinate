package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PointListTest {
    @Test
    void 중복좌표테스트() {
        assertThatIllegalArgumentException().isThrownBy(() ->{
            new PointList(PointFactory.generateCoordinateList(Arrays.asList("0,0","0,0","7,5","10,0")));
        });
    }

}
