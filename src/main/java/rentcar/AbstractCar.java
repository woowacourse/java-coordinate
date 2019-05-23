package rentcar;

public abstract class AbstractCar implements Car {
	private static final int MIN_DISTANCE = 0;
	private final int distance;

	public AbstractCar(final int distance) {
		validate(distance);
		this.distance = distance;
	}

	private void validate(final int distance) {
		if (distance < MIN_DISTANCE) {
			throw new IllegalArgumentException("0 이상의 이동거리를 입력하세요");
		}
	}

	@Override
	public Double getChargedLiter() {
		return (this.distance / getDistancePerLiter());
	}
}
