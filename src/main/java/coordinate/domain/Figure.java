package coordinate.domain;

import coordinate.domain.generator.LinesGenerator;

public abstract class Figure implements AreaCalculator {
    private Points points;
    private Lines lines;

    protected Figure(final Points points, final LinesGenerator linesGenerator) {
        this.points = points;
        this.lines = linesGenerator.generate();
        validateSize();
    }

    protected void validateSize() {
        if (size() != points.size()) {
            throw new IllegalArgumentException();
        }
    }

    protected abstract int size();

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
