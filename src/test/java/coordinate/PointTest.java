package coordinate;

import coordinate.domain.Point;
import coordinate.domain.PointFactory;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PointTest {

    @Test
    void 점이_24를넘는지_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() ->{
            PointFactory.generatePoint("25","1");
        });
    }

    @Test
    void 점이_음수인지_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() ->{
            PointFactory.generatePoint("-1","20");
        });
    }

    @Test
    void 점이_공백을입력받았는지_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() ->{
            PointFactory.generatePoint("","20");
        });
        assertThatIllegalArgumentException().isThrownBy(() ->{
            PointFactory.generatePoint("     ","20");
        });
    }

    @Test
    void 점이_문자열을_입력받았는지_테스트() {
              assertThatIllegalArgumentException().isThrownBy(() ->{
                  PointFactory.generatePoint("aadsds","20");
        });
    }

    @Test
    void 입력에_공백_확인() {
        assertThatIllegalArgumentException().isThrownBy(() ->{
            PointFactory.generatePoint("1 0","20");
        });
    }


}
