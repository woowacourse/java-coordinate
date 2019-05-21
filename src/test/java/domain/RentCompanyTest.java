package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RentCompanyTest {
    private static final String NEW_LINE = System.getProperty("line.separator");

    @Test
    void generateReportTest() {
        RentCompany rentCompany = RentCompany.create();
        rentCompany.addCar(new Sonata(150));
        rentCompany.addCar(new K5(260));
        rentCompany.addCar(new Sonata(120));
        rentCompany.addCar(new Avante(300));
        rentCompany.addCar(new K5(390));
        String report = rentCompany.generateReport();
        assertThat(report).isEqualTo(
                "Sonata : 15리터" + NEW_LINE +
                        "K5 : 20리터" + NEW_LINE +
                        "Sonata : 12리터" + NEW_LINE +
                        "Avante : 20리터" + NEW_LINE +
                        "K5 : 30리터" + NEW_LINE
        );
    }
}
