package com.woowa.coordinate;

import org.junit.jupiter.api.Test;

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
}
