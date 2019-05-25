package rentcar.domain;

public class Sonata extends AbstractCar {
	private static final double DISTANCE_FOR_LITTER = 10;
	private static final String NAME_OF_CAR = "Sonata";

	public Sonata(final int distance) {
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
