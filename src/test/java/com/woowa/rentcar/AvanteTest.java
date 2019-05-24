package com.woowa.rentcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AvanteTest {
    @Test
    void getName() {
        assertThat(new Avante(1).getName()).isEqualTo("Avante");
    }
}