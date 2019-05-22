package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CoordinateListTest {

    @Test
    void 중복좌표테스트() {
        assertThatIllegalArgumentException().isThrownBy(() ->{
            CoordinateList cl = new CoordinateList(CoordinateFactory.generateCoordinateList(Arrays.asList("0,0","0,0","7,5","10,0")));
        });
    }
}
