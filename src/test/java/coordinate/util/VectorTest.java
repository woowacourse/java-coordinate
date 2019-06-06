package coordinate.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VectorTest {
    Vector v1;
    Vector v2;


    @BeforeEach
    void setUp() {
        v1 = new Vector(2,2);
        v2 = new Vector(0,1);
    }

    @Test
    void dotProduct() {
        assertThat(v1.dotProduct(v2)).isEqualTo(2);
    }

    @Test
    void crossProduct() {
        assertThat(v1.crossProduct(v2)).isEqualTo(2);

    }

    @Test
    void length() {
        Vector v3 = new Vector(3,4);
        assertThat(v3.length()).isEqualTo(5);
    }

    @Test
    void add_without_change() {
        Vector expected = new Vector(2,3);
        assertThat(v1.add(v2)).isEqualTo(expected);
        assertThat(v1).isEqualTo(new Vector(2,2));
    }

    @Test
    void compareTo() {
        assertThat(v1.compareTo(v2)).isEqualTo(1);
    }
}