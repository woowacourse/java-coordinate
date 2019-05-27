package com.woowa.coordinate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointTest {
    @Test
    void generate_valid_point() {
        Point point1 = new Point(1, 1);
        assertThat(new Point(1, 1)).isEqualTo(point1);
    }

    @Test
    void generate_invalid_point() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Point(-1, 1);
        });
    }
}
