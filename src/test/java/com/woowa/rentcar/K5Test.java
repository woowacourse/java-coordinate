package com.woowa.rentcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class K5Test {
    @Test
    void getName() {
        assertThat(new K5(1).getName()).isEqualTo("K5");
    }
}