package car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentCompanyTest {
    @Test
    void generateReport() {
        RentCompany company = RentCompany.create();
        company.addCar(new Sonata(150))
                .addCar(new K5(260))
                .addCar(new Sonata(120))
                .addCar(new Avante(300))
                .addCar(new K5(390));

        String report = company.generateReport();
        assertEquals("car.Sonata : 15.0리터" + "\n" +
                    "car.K5 : 20.0리터" + "\n" +
                    "car.Sonata : 12.0리터" + "\n" +
                    "car.Avante : 20.0리터" + "\n" +
                    "car.K5 : 30.0리터" + "\n",
                    report);
    }
}