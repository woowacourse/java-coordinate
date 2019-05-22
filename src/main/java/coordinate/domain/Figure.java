package coordinate.domain;

import coordinate.domain.generator.LinesGenerator;

public abstract class Figure {
    private Points points;
    private Lines lines;

    protected Figure(final Points points, final LinesGenerator linesGenerator) {
        this.points = points;
        this.lines = lines = linesGenerator.generate();
        validate();
    }

    protected abstract void validate();

    protected void validateSize(int size){
        if(size!=points.size()) {
            throw new IllegalArgumentException();
        }
    }

    public abstract double area();

    public Points getPoints() {
        return points;
    }

    public Lines getLines() {
        return lines;
    }
}
