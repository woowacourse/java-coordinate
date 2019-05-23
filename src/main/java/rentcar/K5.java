package rentcar;

public class K5 extends Car {
	private static final double DISTANCE_FOR_LITTER = 13.0;
	private static final String NAME_OF_CAR = "K5";

	public K5(final int distance) {
		super(distance);
	}

	@Override
	Double getDistancePerLiter() {
		return DISTANCE_FOR_LITTER;
	}

	@Override
	Double getChargedLiter() {
		return super.getChargedLiter();
	}

	@Override
	String getName() {
		return NAME_OF_CAR;
	}
}
