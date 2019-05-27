package coord.model.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CombinationsTest {
    @Test
    void combTestA() {
        Combinations comb = new Combinations(6, 4);
        assertThat(comb.next()).isEqualTo(Arrays.asList(0, 1, 2, 3));
        assertThat(comb.next()).isEqualTo(Arrays.asList(0, 1, 2, 4));
        assertThat(comb.next()).isEqualTo(Arrays.asList(0, 1, 2, 5));
        assertThat(comb.next()).isEqualTo(Arrays.asList(0, 1, 3, 4));
        assertThat(comb.next()).isEqualTo(Arrays.asList(0, 1, 3, 5));
        assertThat(comb.next()).isEqualTo(Arrays.asList(0, 1, 4, 5));
        assertThat(comb.next()).isEqualTo(Arrays.asList(0, 2, 3, 4));
        assertThat(comb.next()).isEqualTo(Arrays.asList(0, 2, 3, 5));
        assertThat(comb.next()).isEqualTo(Arrays.asList(0, 2, 4, 5));
        while(comb.hasNext()) {
            System.out.println(comb.next());
        }
    }

    @Test
    void combTestB() {
        Combinations comb = new Combinations(3, 3);
        assertThat(comb.next()).isEqualTo(Arrays.asList(0, 1, 2));
    }
}