package coordinatecalculator.domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputVerificationTest {
    @Test
    void 올바른_입력1() {
        String input = "(0,0)-(0,1)-(1,0)-(1,1)";
        assertThat(InputVerification.getValidPoints(input)).isEqualTo(PointTest.answer1);
    }

    @Test
    void 올바른_입력2() {
        List<Point> points = Collections.singletonList(PointTest.zero_zero);
        assertThat(InputVerification.getValidPoints("(0,0)")).isEqualTo(points);
    }

    @Test
    void 입력_패턴_불일치() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputVerification.getValidPoints("0,0-1,1");
        });
    }

    @Test
    void 좌표가_정수가_아닌_경우() {
        assertThrows(NumberFormatException.class, () -> {
            InputVerification.getValidPoints("(0,0)-(1,a)");
        });
    }

    @Test
    void 중복된_좌표() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputVerification.getValidPoints("(0,0)-(0,0)");
        });
    }
}