package rentcar;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
	List<Car> cars;

	private RentCompany() {
		cars = new ArrayList<>();
	}

	public static RentCompany create() {
		return new RentCompany();
	}

	public void addCar(Car car) {
		cars.add(car);
	}

	public String generateReport() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Car car : cars) {
			stringBuilder.append(car.getName() + " : ");
			stringBuilder.append(car.getChargedLiter().intValue() + "리터");
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}
}
