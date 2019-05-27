package car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RentCompanyTest {
    @Test
    void generateReport() {
        RentCompany company = RentCompany.create();
        company.addCar(new Sonata(150))
                .addCar(new K5(260))
                .addCar(new Sonata(120))
                .addCar(new Avante(300))
                .addCar(new K5(390));
        assertThat(company.generateReport()).isEqualTo(
                "car.Sonata : 15리터\n" +
                "car.K5 : 20리터\n" +
                "car.Sonata : 12리터\n" +
                "car.Avante : 20리터\n" +
                "car.K5 : 30리터\n"
        );
    }
}