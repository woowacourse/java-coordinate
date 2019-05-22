package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class SquareTest {

    @Test
    void 입력이_사다리꼴() {
        CoordinateList cl = new CoordinateList(CoordinateFactory.generateCoordinateList(Arrays.asList("0,0","3,5","7,5","10,0")));
        assertThatIllegalArgumentException().isThrownBy(() ->{
            new Square(cl);
        });
    }

    @Test
    void 입력이_마름모() {
        CoordinateList cl = new CoordinateList(CoordinateFactory.generateCoordinateList(Arrays.asList("1,0","0,1","2,1","1,2")));
        assertThatIllegalArgumentException().isThrownBy(() ->{
            new Square(cl);
        });
    }
}
