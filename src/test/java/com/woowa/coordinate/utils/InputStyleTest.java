package com.woowa.coordinate.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputStyleTest {
    @Test
    void valid_input_a_point() {
        assertThat(InputParser.point("(1,2)")).isEqualTo(true);
    }

    @Test
    void valid_input_two_points() {
        assertThat(InputParser.point("(1,2)-(3,4)")).isEqualTo(true);
    }

    @Test
    void invalid_input() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputParser.point("-(1,2)");
        });
    }
}