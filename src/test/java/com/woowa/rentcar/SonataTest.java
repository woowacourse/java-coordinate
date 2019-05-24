package com.woowa.rentcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SonataTest {
    @Test
    void getName() {
        assertThat(new Sonata(1).getName()).isEqualTo("Sonata");
    }
}