package coord.model.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CombinationsTest {
    @Test
    void combTestA() {
        Combinations comb = new Combinations(6, 4);
        assertEquals(Arrays.asList(0, 1, 2, 3), comb.next());
        assertEquals(Arrays.asList(0, 1, 2, 4), comb.next());
        assertEquals(Arrays.asList(0, 1, 2, 5), comb.next());
        assertEquals(Arrays.asList(0, 1, 3, 4), comb.next());
        assertEquals(Arrays.asList(0, 1, 3, 5), comb.next());
        assertEquals(Arrays.asList(0, 1, 4, 5), comb.next());
        assertEquals(Arrays.asList(0, 2, 3, 4), comb.next());
        while(comb.hasNext()) {
            System.out.println(comb.next());
        }
    }

    @Test
    void combTestB() {
        Combinations comb = new Combinations(3, 3);
        assertEquals(Arrays.asList(0, 1, 2), comb.next());
    }
}