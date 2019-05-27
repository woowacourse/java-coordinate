package com.woowa.coordinate;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CoordinateTest {
    @Test
    void coordinate_value_lower_bound_zero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Coordinate(-1);
        });
    }

    @Test
    void coordinate_value_upper_bound_24() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Coordinate(25);
        });
    }

    @Test
    void coordinate_subtract() {
        Coordinate coordinate1 = new Coordinate(10);
        Coordinate coordinate2 = new Coordinate(1);
        assertThat(coordinate1.subtract(coordinate2)).isEqualTo(9);
    }

    @Test
    void coordinate_subtract_reverse() {
        Coordinate coordinate1 = new Coordinate(1);
        Coordinate coordinate2 = new Coordinate(10);
        assertThat(coordinate1.subtract(coordinate2)).isEqualTo(9);
    }
}
