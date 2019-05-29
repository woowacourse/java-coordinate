package coordinate.domain;

import coordinate.domain.generator.LinesGenerator;

public abstract class Figure implements AreaCalculator {
    private Points points;

    protected Figure(final Points points) {
        this.points = points;
        validate();
    }

    protected abstract void validate();

    protected void validateSize(int size) {
        if (size != points.size()) {
            throw new IllegalArgumentException("해당 도형에 필요한 점 갯수가 아닙니다.");
        }
    }

    Point getPoint(int index) {
        return points.get(index);
    }

    public Points getPoints() {
        return points;
    }

    @Override
    public double area() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Lines makeLines() {
        return LinesGenerator.generateLines(getPoints());
    }
}
