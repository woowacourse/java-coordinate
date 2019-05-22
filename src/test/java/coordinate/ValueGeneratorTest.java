package coordinate;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ValueGeneratorTest {
    @Test
    void 좌표값_구분자_테스트() {
        List<String> test = Arrays.asList("(1,2)", "(2,3)", "(3,4)");
        assertThat(ValueGenerator.splitCoordinates("(1,2)-(2,3)-(3,4)")).isEqualTo(test);
    }

    @Test
    void 괄호_제거_테스트(){
        assertThat(ValueGenerator.removeBrackets("(1,2)")).isEqualTo("1,2");
    }

    @Test
    void 좌표_구분자_테스트() {
        List<String> test = Arrays.asList("1", "2");
        assertThat(ValueGenerator.splitValue("1,2")).isEqualTo(test);
    }
}


