package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PointFactoryTest {

    @Test
    void 점이_문자열을_입력받았는지_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() ->{
            PointFactory.generatePoints(Arrays.asList("(1,dd)","(2,3)"));
        });
    }

    @Test
    void 입력에_공백_확인() {
        assertThatIllegalArgumentException().isThrownBy(() ->{
            PointFactory.generatePoints(Arrays.asList("(1,20  )","(2,3)"));
        });
    }
    @Test
    void 좌표사_한개() {
        assertThatIllegalArgumentException().isThrownBy(() ->{
            new Points(Arrays.asList(new Point(1, 0)));
        });
    }

    @Test
    void 좌표사_다섯개() {
        assertThatIllegalArgumentException().isThrownBy(() ->{
            new Points(Arrays.asList(new Point(1, 0),new Point(1, 0),new Point(2, 0),new Point(3, 0),new Point(4, 0),new Point(5, 0)));
        });
    }
}
