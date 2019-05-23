package rentcar;

public class Sonata extends Car {
	private static final double DISTANCE_FOR_LITTER = 10;
	private static final String NAME_OF_CAR = "Sonata";

	public Sonata(final int distance) {
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
