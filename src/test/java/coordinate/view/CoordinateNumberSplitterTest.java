package coordinate.view;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CoordinateNumberSplitterTest {

    @Test
    void split_점_1개() {
        String input = "(1,2)";

        assertThat(CoordinateNumberSplitter.split(input)).isEqualTo(Arrays.asList(1, 2));
    }

    @Test
    void split_점_2개() {
        String input = "(1,2)-(3,4)";

        assertThat(CoordinateNumberSplitter.split(input)).isEqualTo(Arrays.asList(1, 2, 3, 4));
    }
}