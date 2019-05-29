package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PointFactoryTest {

    @Test
    void 점이_문자열을_입력받았는지_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            PointFactory.generatePoints(Arrays.asList("(1,dd)", "(2,3)"));
        });
    }

    @Test
    void 입력에_공백_확인() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            PointFactory.generatePoints(Arrays.asList("(1,20  )", "(2,3)"));
        });
    }

}
