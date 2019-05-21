package car;

import org.junit.jupiter.api.Test;

class SonataTest {

    @Test
    void init() {
        System.out.println(new Sonata(150).getName());
    }

    @Test
    void chargeQuantityTest() {
        System.out.println(new Sonata(255).getChargeQuantity());
    }
}