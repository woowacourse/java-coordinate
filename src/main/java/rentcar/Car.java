package rentcar;

public abstract class Car {
	private final int distance;

	public Car(final int distance) {
		this.distance = distance;
	}

	abstract Double getDistancePerLiter();

	Double getChargedLiter() {
		return (this.distance / getDistancePerLiter());
	}

	abstract String getName();
}
