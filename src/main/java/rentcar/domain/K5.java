package rentcar.domain;

public class K5 extends AbstractCar {
	private static final double DISTANCE_FOR_LITTER = 13.0;
	private static final String NAME_OF_CAR = "K5";

	public K5(final int distance) {
		super(distance);
	}

	@Override
	public Double getDistancePerLiter() {
		return DISTANCE_FOR_LITTER;
	}

	@Override
	public Double getChargedLiter() {
		return super.getChargedLiter();
	}

	@Override
	public String getName() {
		return NAME_OF_CAR;
	}
}
