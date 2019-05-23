package car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {
    @Test
    void initTest() {
        new Sonata(150);
    }

    @Test
    void chargeQuantityTest() {
        assertEquals(17, new Avante(255).getChargeQuantity());
    }

    @Test
    void getNameTest() {
        assertEquals("K5", new K5(123).getName());
    }
}