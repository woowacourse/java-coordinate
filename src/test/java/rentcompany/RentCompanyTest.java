package rentcompany;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RentCompanyTest {

    private RentCompany rentCompany;

    @BeforeEach
    void setUp() {
        rentCompany = RentCompany.newInstance();

        rentCompany.addCar(new Sonata(150));
        rentCompany.addCar(new K5(260));
        rentCompany.addCar(new Sonata(120));
        rentCompany.addCar(new Avante(300));
        rentCompany.addCar(new K5(390));
    }

    @Test
    void 차객체_저장() {
        assertThat(rentCompany.getCars()).isEqualTo(Arrays.asList(new Sonata(150), new K5(260), new Sonata(120), new Avante(300), new K5(390)));
    }

    @Test
    void Report() {
        assertThat(rentCompany.generateReport()).isEqualTo("Sonata : 15리터\n" + "K5 : 20리터\n" + "Sonata : 12리터\n" + "Avante : 20리터\n" + "K5 : 30리터\n");
    }
}
