package coordinate.model.creator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SplitterTest {
    @Test
    void 좌표값_구분자_테스트() {
        List<String> test = Arrays.asList("1", "2", "2", "3", "3", "4");
        assertThat(Splitter.splitValue("(1,2)-(2,3)-(3,4)")).isEqualTo(test);
    }
}


