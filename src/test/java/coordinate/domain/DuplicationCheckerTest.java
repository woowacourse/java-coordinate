package coordinate.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DuplicationCheckerTest {

    @Test
    void hasDuplication_중복존재() {
        List<Integer> numbers = Arrays.asList(1, 2, 2);

        assertThat(DuplicationChecker.hasDuplication(numbers)).isTrue();
    }
}