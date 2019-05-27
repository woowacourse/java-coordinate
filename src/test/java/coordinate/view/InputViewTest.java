package coordinate.view;

import coordinate.domain.PointsGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.in;

class InputViewTest {
    @ParameterizedTest
    @ValueSource(strings = {"(1,3)", "(1,3)(3,5)", "(1,3)-(3,5)-(24,25)-(5,7)-(6,5)", "(1-3)-(2,5)"})
    void 좌표_입력_유효성_테스트() {
        String input = "(1,3)(3,5)-(24,25)";
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            PointsGenerator.of(input);
        }).withMessage("입력 형식이 맞지 않습니다.");
    }
}
