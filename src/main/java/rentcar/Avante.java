package rentcar;

public class Avante extends AbstractCar {
	private static final double DISTANCE_FOR_LITTER = 15;
	private static final String NAME_OF_CAR = "Avante";

	public Avante(final int distance) {
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
