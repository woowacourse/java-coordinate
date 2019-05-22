package coordinate.domain;

import coordinate.domain.generator.LinesGenerator;

public abstract class Figure implements AreaCalculator {
    private Points points;
    private Lines lines;

    protected Figure(final Points points, final LinesGenerator linesGenerator) {
        this.points = points;
        this.lines = lines = linesGenerator.generate();
        validate();
    }

    protected abstract void validate();

    protected void validateSize(int size) {
        if (size != points.size()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public double area() {
        throw new UnsupportedOperationException();
    }

    public Points getPoints() {
        return points;
    }

    public Lines getLines() {
        return lines;
    }
}
