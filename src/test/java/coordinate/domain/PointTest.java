package coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PointTest {

    @Test
    void 점이_24를넘는지_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() ->{
            new Point(25,1);
        });
    }

    @Test
    void 점이_음수인지_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() ->{
            new Point(-1,20);
        });
    }

}
