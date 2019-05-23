package coordinate;

public class Line {

	private final Point first;
	private final Point second;

	public Line(final Point first, final Point second) {
		this.first = first;
		this.second = second;
	}

	public Double length() {
		Double tempX = first.getX().doubleValue() - second.getX().doubleValue();
		Double tempY = first.getY().doubleValue() - second.getY().doubleValue();

		return Math.sqrt(Math.pow(tempX, 2) + Math.pow(tempY, 2));
	}
}
