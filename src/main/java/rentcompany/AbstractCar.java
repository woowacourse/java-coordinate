package rentcompany;

public class AbstractCar implements Car {
    @Override
    public int calculateFuel() {
        return 0;
    }

    @Override
    public String generateReport() {
        return null;
    }
}
