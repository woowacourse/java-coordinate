package rentcar;

public class Avante extends Car {
	private static final double DISTANCE_FOR_LITTER = 15;
	private static final String NAME_OF_CAR = "Avante";

	public Avante(final int distance) {
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
